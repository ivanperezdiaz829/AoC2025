package software.aoc.day02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObtainRanges implements RangeReader {

    @Override
    public List<IdRange> readRanges(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(range -> !range.isEmpty())
                .map(range -> {
                    String[] parts = range.split("-");
                    long start = Long.parseLong(parts[0].trim());
                    long end = Long.parseLong(parts[1].trim());
                    return new IdRange(start, end);
                })
                .collect(Collectors.toList());
    }
}
