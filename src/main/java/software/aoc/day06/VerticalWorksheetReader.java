package software.aoc.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerticalWorksheetReader implements WorksheetReader {
    @Override
    public Worksheet read(String input) {
        String linesArray[] = input.split("\n");
        int maxLen = Arrays.stream(linesArray).mapToInt(String::length).max().orElse(0);

        List<String> lines = Arrays.stream(linesArray)
                .map(line -> String.format("%-" + maxLen + "s", line))
                .toList();
        List<MathProblem> problems = new ArrayList<>();
        int startCol = 0;

        while (startCol < maxLen) {
            while (startCol < maxLen && isBlankColumn(lines, startCol)) { startCol++; }
            if (startCol >= maxLen) break;
            int endCol = startCol;
            while (endCol < maxLen && !isBlankColumn(lines, endCol)) { endCol++; }

            problems.add(parseProblem(lines, startCol, endCol));
            startCol = endCol;
        }
        return new Worksheet(problems);
    }

    private MathProblem parseProblem(List<String> lines, int startCol, int endCol) {
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
        if (operator == null) { throw new IllegalStateException("No operator found."); }
        return new MathProblem(operands, operator);
    }

    private boolean isBlankColumn(List<String> lines, int colIndex) {
        return lines.stream().allMatch(line -> line.charAt(colIndex) == ' ');
    }


}
