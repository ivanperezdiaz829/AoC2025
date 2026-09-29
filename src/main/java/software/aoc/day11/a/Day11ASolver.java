package software.aoc.day11.a;

import software.aoc.Solver;
import software.aoc.day11.*;

public class Day11ASolver implements Solver {

    @Override
    public long solve(String input) {
        ReactorNetworkReader reader = new ObtainReactorNetwork();
        PathCountingStrategy strategy = new MemoizedDFSPathCountingStrategy();
        PathQuery query = new PathQuery("you", "out");
        Day11Solver coreSolver = new Day11Solver(reader, strategy, query);
        return coreSolver.execute(input);
    }
}
