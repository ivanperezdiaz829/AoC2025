package software.aoc.day05.a;

import software.aoc.day05.FreshnessRule;
import software.aoc.day05.InventoryDatabase;
import software.aoc.day05.InventoryStrategy;

public class AvailableIngredientsStrategy implements InventoryStrategy {

    private final FreshnessRule rule;

    public AvailableIngredientsStrategy(FreshnessRule rule) {
        this.rule = rule;
    }

    @Override
    public long calculate(InventoryDatabase database) {
        return database.availableIds().stream()
                .filter(id -> rule.isFresh(id, database.freshRanges()))
                .count();
    }
}