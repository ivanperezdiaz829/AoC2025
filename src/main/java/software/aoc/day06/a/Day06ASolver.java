package software.aoc.day06.a;

import software.aoc.Solver;
import software.aoc.day06.Day06Solver;

public class Day06ASolver implements Solver {
    @Override
    public long solve(String input) {
        return new Day06Solver(new VerticalWorksheetReader()).execute(input);
    }
}
