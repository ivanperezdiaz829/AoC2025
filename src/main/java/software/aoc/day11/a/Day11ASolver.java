package software.aoc.day11.a;

import software.aoc.Solver;
import software.aoc.day11.Day11Solver;
import software.aoc.day11.MemoizedDFSPathCountingStrategy;
import software.aoc.day11.PathCountingStrategy;
import software.aoc.day11.ReactorNetworkReader;

public class Day11ASolver implements Solver {

    @Override
    public long solve(String input) {
        ReactorNetworkReader reader = new ReactorNetworkReader();
        PathCountingStrategy strategy = new MemoizedDFSPathCountingStrategy();
        Day11Solver coreSolver = new Day11Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
