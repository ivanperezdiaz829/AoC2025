package software.aoc.day05;

import java.util.List;

public interface FreshnessRule {
    public boolean isFresh(long id, List<IngredientsRange> ranges);
}
