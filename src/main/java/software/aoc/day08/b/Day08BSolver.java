package software.aoc.day08.b;

import software.aoc.Solver;
import software.aoc.day08.ConnectionStrategy;
import software.aoc.day08.Day08Solver;
import software.aoc.day08.PlaygroundReader;

public class Day08BSolver implements Solver {
    @Override
    public long solve(String input) {
        PlaygroundReader reader = new PlaygroundReader();
        ConnectionStrategy strategy = new CompleteCircuitConnectionStrategy();
        Day08Solver coreSolver = new Day08Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
