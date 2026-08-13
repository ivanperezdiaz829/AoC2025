package software.aoc.day06.b;

import software.aoc.day06.AbstractWorksheetReader;
import software.aoc.day06.MathProblem;
import software.aoc.day06.Operator;

import java.util.ArrayList;
import java.util.List;

public class CephalopodWorksheetReader extends AbstractWorksheetReader {

    @Override
    protected MathProblem parseProblem(List<String> lines, int startCol, int endCol) {
        List<Long> operands = new ArrayList<>();
        Operator operator = null;
        int operatorRow = -1;

        for (int index = 0; index < lines.size(); index++) {
            String token = lines.get(index).substring(startCol, endCol).trim();
            if (token.equals("+") || token.equals("*")) {
                operator = Operator.fromSymbol(token);
                operatorRow = index;
                break;
            }
        }

        for (int col = endCol - 1; col >= startCol; col--) {
            StringBuilder numberStr = new StringBuilder();

            for (int row = 0; row < lines.size(); row++) {
                if (row == operatorRow) continue;
                char c = lines.get(row).charAt(col);
                if (Character.isDigit(c)) { numberStr.append(c); }
            }
            if (!numberStr.isEmpty()) { operands.add(Long.parseLong(numberStr.toString())); }
        }

        if (operator == null) { throw new IllegalStateException("No operator found in cephalopod math problem block."); }
        return new MathProblem(operands, operator);
    }
}