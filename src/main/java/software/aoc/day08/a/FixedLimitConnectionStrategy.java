package software.aoc.day08.a;

import software.aoc.day08.BoxPair;
import software.aoc.day08.ConnectionStrategy;
import software.aoc.day08.UnionFinder;

import java.util.Comparator;
import java.util.List;

public class FixedLimitConnectionStrategy implements ConnectionStrategy {
    private final int limit;

    public FixedLimitConnectionStrategy(int limit) {
        this.limit = limit;
    }

    @Override
    public long applyConnections(int totalBoxes, List<BoxPair> sortedPairs) {
        UnionFinder unionFinder = new UnionFinder(totalBoxes);

        for (int i = 0; i < limit && i < sortedPairs.size(); i++) {
            BoxPair pair = sortedPairs.get(i);
            unionFinder.union(pair.box1().id(), pair.box2().id());
        }
        return unionFinder.getComponentSizes().stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToLong(Integer::longValue)
                .reduce(1L, (a, b) -> a * b);
    }
}
