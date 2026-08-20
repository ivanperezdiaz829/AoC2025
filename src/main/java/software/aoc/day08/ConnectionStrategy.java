package software.aoc.day08;

import java.util.List;

public interface ConnectionStrategy {
    List<Integer> applyConnections(int totalBoxes, List<BoxPair> sortedPairs);
}
