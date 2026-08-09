package software.aoc.day04;

import java.util.List;
import java.util.stream.Collectors;

public class ObtainGrid implements GridReader {
    @Override
    public PaperGrid readGrid(String input) {
        List<String> rows = input.lines()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());
        return new PaperGrid(rows);
    }
}
