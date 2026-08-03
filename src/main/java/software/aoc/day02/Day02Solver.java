package software.aoc.day02;

import java.util.List;
import java.util.stream.LongStream;

public class Day02Solver {

    private final RangeReader reader;
    private final IdValidator validator;

    public Day02Solver(RangeReader reader, IdValidator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public long execute(String input) {
        List<IdRange> ranges = reader.readRanges(input);
        return ranges.stream()
                .mapToLong(range -> LongStream.rangeClosed(range.start(), range.end())
                        .filter(validator::isInvalid)
                        .sum())
                .sum();
    }
}
