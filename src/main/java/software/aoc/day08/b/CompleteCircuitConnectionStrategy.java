package software.aoc.day08.b;

import software.aoc.day08.BoxPair;
import software.aoc.day08.ConnectionStrategy;
import software.aoc.day08.UnionFinder;

import java.util.List;

public class CompleteCircuitConnectionStrategy implements ConnectionStrategy {
    @Override
    public long applyConnections(int totalBoxes, List<BoxPair> sortedPairs) {
        UnionFinder unionFinder = new UnionFinder(totalBoxes);
        int remainingCircuits = totalBoxes;

        for (BoxPair pair : sortedPairs) {
            if (unionFinder.union(pair.box1().id(),  pair.box2().id())) {
                remainingCircuits--;
                if (remainingCircuits == 1) {
                    long x1 = pair.box1().position().x();
                    long x2 = pair.box2().position().x();
                    return x1 * x2;
                }
            }
        }
        throw new IllegalStateException("The circuit can't be closed using input boxes");
    }
}
