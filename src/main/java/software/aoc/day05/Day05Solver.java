package software.aoc.day05;

public class Day05Solver {

    private final DatabaseReader reader;
    private final InventoryStrategy strategy;

    public Day05Solver(DatabaseReader reader, InventoryStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        InventoryDatabase database = reader.readDatabase(input);
        return strategy.calculate(database);
    }
}