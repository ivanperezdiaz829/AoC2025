package software.aoc.day04;

public class Day04Solver {

    private final GridReader reader;
    private final AccessRule rule;
    private final RemovalStrategy strategy;

    public Day04Solver(GridReader reader, AccessRule rule, RemovalStrategy strategy) {
        this.reader = reader;
        this.rule = rule;
        this.strategy = strategy;
    }

    public long execute(String input) {
        PaperGrid grid = reader.readGrid(input);
        return strategy.run(grid, rule);
    }
}