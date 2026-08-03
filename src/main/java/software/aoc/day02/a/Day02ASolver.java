package software.aoc.day02.a;

import software.aoc.SafeSolver;
import software.aoc.day02.*;

public class Day02ASolver implements SafeSolver {
    @Override
    public long solve(String input) {
        RangeReader reader = new ObtainRanges();
        IdValidator validator = new RepeatedSequenceValidator();

        Day02Solver solver = new Day02Solver(reader, validator);
        return solver.execute(input);
    }
}
