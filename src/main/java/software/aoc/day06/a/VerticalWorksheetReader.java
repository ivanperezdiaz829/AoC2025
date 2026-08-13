package software.aoc.day06.a;

import software.aoc.day06.AbstractWorksheetReader;
import software.aoc.day06.MathProblem;
import software.aoc.day06.Operator;

import java.util.ArrayList;
import java.util.List;

public class VerticalWorksheetReader extends AbstractWorksheetReader {

    @Override
    protected MathProblem parseProblem(List<String> lines, int startCol, int endCol) {
        List<Long> operands = new ArrayList<>();
        Operator operator = null;

        for (String line : lines) {
            String token = line.substring(startCol, endCol).trim();
            if (token.isEmpty()) { continue; }

            if (token.equals("+") || token.equals("*")) {
                operator = Operator.fromSymbol(token);
            } else {
                operands.add(Long.parseLong(token));
            }
        }

        if (operator == null) { throw new IllegalStateException("No operator found in math problem block."); }
        return new MathProblem(operands, operator);
    }
}