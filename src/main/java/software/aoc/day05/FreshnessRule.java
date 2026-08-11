package software.aoc.day05;

import java.util.List;

public interface FreshnessRule {
    boolean isFresh(long id, List<IngredientsRange> ranges);
}
