package software.aoc.day05.a;

import software.aoc.SafeSolver;
import software.aoc.day05.DatabaseReader;
import software.aoc.day05.Day05Solver;
import software.aoc.day05.FreshnessRule;
import software.aoc.day05.ObtainDatabase;

public class Day05ASolver implements SafeSolver {
    @Override
    public long solve(String input) {
        DatabaseReader reader = new ObtainDatabase();
        FreshnessRule rule = new RangeOverlapFreshnessRule();

        Day05Solver coreSolver = new Day05Solver(reader, rule);
        return coreSolver.execute(input);
    }
}
