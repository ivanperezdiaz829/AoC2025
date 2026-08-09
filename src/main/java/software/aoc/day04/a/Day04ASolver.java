package software.aoc.day04.a;

import software.aoc.SafeSolver;
import software.aoc.day04.*;

public class Day04ASolver implements SafeSolver {

    @Override
    public long solve(String input) {
        GridReader reader = new ObtainGrid();
        AccessRule rule = new FewerThanFourAdjacentRule();

        Day04Solver coreSolver = new Day04Solver(reader, rule);
        return coreSolver.execute(input);
    }
}