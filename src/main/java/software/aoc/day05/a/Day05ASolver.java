package software.aoc.day05.a;

import software.aoc.Solver;
import software.aoc.day05.DatabaseReader;
import software.aoc.day05.Day05Solver;
import software.aoc.day05.FreshnessRule;
import software.aoc.day05.InventoryStrategy;
import software.aoc.day05.ObtainDatabase;

public class Day05ASolver implements Solver {

    @Override
    public long solve(String input) {
        DatabaseReader reader = new ObtainDatabase();
        FreshnessRule rule = new RangeOverlapFreshnessRule();
        InventoryStrategy strategy = new AvailableIngredientsStrategy(rule);

        Day05Solver coreSolver = new Day05Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}