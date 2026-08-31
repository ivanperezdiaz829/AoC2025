package software.aoc.day11.b;

import software.aoc.Solver;
import software.aoc.day11.Day11Solver;
import software.aoc.day11.PathCountingStrategy;
import software.aoc.day11.PathQuery;
import software.aoc.day11.ReactorNetworkReader;

public class Day11BSolver implements Solver {
    @Override
    public long solve(String input) {
        ReactorNetworkReader reader = new ReactorNetworkReader();
        PathCountingStrategy strategy = new MandatoryNodesPathCountingStrategy("dac", "fft");
        PathQuery query = new PathQuery("svr", "out");
        Day11Solver coreSolver = new Day11Solver(reader, strategy, query);
        return coreSolver.execute(input);

    }
}
