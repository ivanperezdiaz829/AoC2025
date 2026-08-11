package software.aoc.day05;

public class Day05Solver {

    private final DatabaseReader reader;
    private final FreshnessRule rule;

    public Day05Solver(DatabaseReader reader, FreshnessRule rule) {
        this.reader = reader;
        this.rule = rule;
    }

    public long execute(String input) {
        InventoryDatabase database = reader.readDatabase(input);
        return database.availableIds().stream()
                .filter(id -> rule.isFresh(id, database.freshRanges()))
                .count();
    }
}