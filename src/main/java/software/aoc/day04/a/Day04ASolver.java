package software.aoc.day04.a;

import software.aoc.Solver;
import software.aoc.day04.AccessRule;
import software.aoc.day04.Day04Solver;
import software.aoc.day04.GridReader;
import software.aoc.day04.ObtainGrid;
import software.aoc.day04.RemovalStrategy;

public class Day04ASolver implements Solver {

    @Override
    public long solve(String input) {
        GridReader reader = new ObtainGrid();
        AccessRule rule = new FewerThanFourAdjacentRule();
        RemovalStrategy strategy = new SinglePassStrategy();

        Day04Solver coreSolver = new Day04Solver(reader, rule, strategy);
        return coreSolver.execute(input);
    }
}