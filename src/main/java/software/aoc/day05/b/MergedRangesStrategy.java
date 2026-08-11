package software.aoc.day05.b;

import software.aoc.day05.IngredientsRange;
import software.aoc.day05.InventoryDatabase;
import software.aoc.day05.InventoryStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergedRangesStrategy implements InventoryStrategy {

    @Override
    public long calculate(InventoryDatabase database) {
        List<IngredientsRange> ranges = new ArrayList<>(database.freshRanges());
        if (ranges.isEmpty()) { return 0; }
        ranges.sort(Comparator.comparingLong(IngredientsRange::start));

        long totalFresh = 0;
        IngredientsRange current = ranges.getFirst();

        for (int i = 1; i < ranges.size(); i++) {
            IngredientsRange next = ranges.get(i);
            if (current.overlaps(next)) {
                current = current.merge(next);
            } else {
                totalFresh += current.length();
                current = next;
            }
        }
        return totalFresh + current.length();
    }
}