package software.aoc.day02.b;

import software.aoc.SafeSolver;
import software.aoc.day02.Day02Solver;
import software.aoc.day02.IdValidator;
import software.aoc.day02.ObtainRanges;
import software.aoc.day02.RangeReader;

public class Day02BSolver implements SafeSolver {
    @Override
    public long solve(String input) {
        RangeReader reader = new ObtainRanges();
        IdValidator validator = new AtLeastTwiceSequenceValidator();

        Day02Solver solver = new Day02Solver(reader, validator);
        return solver.execute(input);
    }
}
