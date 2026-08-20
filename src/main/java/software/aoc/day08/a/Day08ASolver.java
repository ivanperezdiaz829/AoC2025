package software.aoc.day08.a;

import software.aoc.Solver;
import software.aoc.day08.ConnectionStrategy;
import software.aoc.day08.Day08Solver;
import software.aoc.day08.FixedLimitConnectionStrategy;
import software.aoc.day08.PlaygroundReader;

public class Day08ASolver implements Solver {
    private final int connectionLimit;

    public Day08ASolver() {
        this(1000);
    }

    public Day08ASolver(int connectionLimit) {
        this.connectionLimit = connectionLimit;
    }

    @Override
    public long solve(String input) {
        PlaygroundReader reader = new PlaygroundReader();
        ConnectionStrategy strategy = new FixedLimitConnectionStrategy(connectionLimit);
        Day08Solver coreSolver = new Day08Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
