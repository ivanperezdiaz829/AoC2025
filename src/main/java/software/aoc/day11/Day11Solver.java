package software.aoc.day11;

public class Day11Solver {

    private final ReactorNetworkReader reader;
    private final PathCountingStrategy strategy;
    private final PathQuery query;

    public Day11Solver(ReactorNetworkReader reader, PathCountingStrategy strategy, PathQuery query) {
        this.reader = reader;
        this.strategy = strategy;
        this.query = query;
    }

    public long execute(String input) {
        ReactorNetwork network = reader.read(input);
        return network.countPathsFrom(query, strategy);
    }
}
