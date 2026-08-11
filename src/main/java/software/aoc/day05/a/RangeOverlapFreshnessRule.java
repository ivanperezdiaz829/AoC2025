package software.aoc.day05.a;

import software.aoc.day05.FreshnessRule;
import software.aoc.day05.IngredientsRange;

import java.util.List;

public class RangeOverlapFreshnessRule implements FreshnessRule {
    @Override
    public boolean isFresh(long id, List<IngredientsRange> ranges) {
        return ranges.stream().anyMatch(range -> range.contains(id));
    }
}
