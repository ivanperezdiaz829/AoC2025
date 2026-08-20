package software.aoc.day08;

import java.util.List;

public class FixedLimitConnectionStrategy implements ConnectionStrategy {
    private final int limit;

    public FixedLimitConnectionStrategy(int limit) {
        this.limit = limit;
    }

    @Override
    public List<Integer> applyConnections(int totalBoxes, List<BoxPair> sortedPairs) {
        UnionFinder unionFinder = new UnionFinder(totalBoxes);

        for (int i = 0; i < limit && i < sortedPairs.size(); i++) {
            BoxPair pair = sortedPairs.get(i);
            unionFinder.union(pair.box1().id(), pair.box2().id());
        }
        return unionFinder.getComponentSizes();
    }
}
