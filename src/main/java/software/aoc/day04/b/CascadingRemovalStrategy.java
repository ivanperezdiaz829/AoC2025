package software.aoc.day04.b;

import software.aoc.day04.AccessRule;
import software.aoc.day04.PaperGrid;
import software.aoc.day04.Position;
import software.aoc.day04.RemovalStrategy;

import java.util.List;

public class CascadingRemovalStrategy implements RemovalStrategy {

    @Override
    public long run(PaperGrid paperGrid, AccessRule rule) {
        long totalRemoved = 0;
        PaperGrid currentGrid = paperGrid;

        while (true) {
            List<Position> toRemove = currentGrid.findAccessibleRolls(rule);
            if (toRemove.isEmpty()) { break; }
            totalRemoved += toRemove.size();
            currentGrid = currentGrid.removeRolls(toRemove);
        }
        return totalRemoved;
    }
}