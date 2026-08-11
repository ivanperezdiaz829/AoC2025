package software.aoc.day04.a;

import software.aoc.day04.AccessRule;
import software.aoc.day04.PaperGrid;
import software.aoc.day04.RemovalStrategy;

public class SinglePassStrategy implements RemovalStrategy {

    @Override
    public long run(PaperGrid paperGrid, AccessRule rule) {
        return paperGrid.findAccessibleRolls(rule).size();
    }
}