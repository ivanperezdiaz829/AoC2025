package software.aoc.day08;

public class Day08Solver {
    private final PlaygroundReader reader;
    private final ConnectionStrategy strategy;

    public Day08Solver(PlaygroundReader reader, ConnectionStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        Playground playground = reader.read(input);
        return playground.applyConnectionStrategy(strategy);
    }
}
