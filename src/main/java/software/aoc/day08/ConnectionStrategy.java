package software.aoc.day08;

import java.util.List;

public interface ConnectionStrategy {
    long applyConnections(int totalBoxes, List<BoxPair> sortedPairs);
}
