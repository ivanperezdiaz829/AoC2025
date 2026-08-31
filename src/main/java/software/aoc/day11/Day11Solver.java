package software.aoc.day11;

public class Day11Solver {

    private final ReactorNetworkReader reader;
    private final PathCountingStrategy strategy;

    public Day11Solver(ReactorNetworkReader reader, PathCountingStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        ReactorNetwork network = reader.read(input);
        return network.countPathsFrom("you", "out", strategy);
    }
}
