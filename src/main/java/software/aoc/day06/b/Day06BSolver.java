package software.aoc.day06.b;

import software.aoc.Solver;
import software.aoc.day06.Day06Solver;

public class Day06BSolver implements Solver {
    @Override
    public long solve(String input) {
        return new Day06Solver(new CephalopodWorksheetReader()).execute(input);
    }
}
