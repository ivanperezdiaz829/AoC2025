package software.aoc.day07.a;

import software.aoc.Solver;
import software.aoc.day07.Day07Solver;
import software.aoc.day07.GridManifoldReader;
import software.aoc.day07.ManifoldReader;

public class Day07ASolver implements Solver {
    @Override
    public long solve(String input) {
        ManifoldReader reader = new GridManifoldReader();
        Day07Solver coreSolver = new Day07Solver(reader);
        return coreSolver.execute(input);
    }
}
