package software.aoc.day06;

import software.aoc.day06.MathProblem;
import software.aoc.day06.Worksheet;
import software.aoc.day06.WorksheetReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractWorksheetReader implements WorksheetReader {

    @Override
    public Worksheet read(String input) {
        String[] linesArray = input.split("\n");
        int maxLen = Arrays.stream(linesArray).mapToInt(String::length).max().orElse(0);

        List<String> paddedLines = Arrays.stream(linesArray)
                .map(line -> String.format("%-" + maxLen + "s", line))
                .toList();

        List<MathProblem> problems = new ArrayList<>();
        int startCol = 0;

        while (startCol < maxLen) {
            while (startCol < maxLen && isBlankColumn(paddedLines, startCol)) { startCol++; }
            if (startCol >= maxLen) break;
            int endCol = startCol;
            while (endCol < maxLen && !isBlankColumn(paddedLines, endCol)) { endCol++; }

            problems.add(parseProblem(paddedLines, startCol, endCol));
            startCol = endCol;
        }
        return new Worksheet(problems);
    }

    private boolean isBlankColumn(List<String> lines, int colIndex) {
        return lines.stream().allMatch(line -> line.charAt(colIndex) == ' ');
    }

    protected abstract MathProblem parseProblem(List<String> lines, int startCol, int endCol);
}