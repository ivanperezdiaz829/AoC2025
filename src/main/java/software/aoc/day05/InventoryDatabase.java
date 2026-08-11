package software.aoc.day05;

import java.util.List;

public record InventoryDatabase(List<IngredientsRange> freshRanges, List<Long> availableIds) {
}
