package software.aoc.day04.b;

import software.aoc.SafeSolver;
import software.aoc.day04.AccessRule;
import software.aoc.day04.Day04Solver;
import software.aoc.day04.GridReader;
import software.aoc.day04.ObtainGrid;
import software.aoc.day04.RemovalStrategy;
import software.aoc.day04.a.FewerThanFourAdjacentRule;

public class Day04BSolver implements SafeSolver {

    @Override
    public long solve(String input) {
        GridReader reader = new ObtainGrid();
        AccessRule rule = new FewerThanFourAdjacentRule();
        RemovalStrategy strategy = new CascadingRemovalStrategy();

        Day04Solver coreSolver = new Day04Solver(reader, rule, strategy);
        return coreSolver.execute(input);
    }
}