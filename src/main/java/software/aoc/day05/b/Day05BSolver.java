package software.aoc.day05.b;

import software.aoc.SafeSolver;
import software.aoc.day05.DatabaseReader;
import software.aoc.day05.Day05Solver;
import software.aoc.day05.InventoryStrategy;
import software.aoc.day05.ObtainDatabase;

public class Day05BSolver implements SafeSolver {

    @Override
    public long solve(String input) {
        DatabaseReader reader = new ObtainDatabase();
        InventoryStrategy strategy = new MergedRangesStrategy();

        Day05Solver coreSolver = new Day05Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
