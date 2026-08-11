package software.aoc.day05;

import java.util.ArrayList;
import java.util.List;

public class ObtainDatabase implements DatabaseReader {
    @Override
    public InventoryDatabase readDatabase(String input) {
        String[] parts = input.replace("\r\n", "\n").split("\n\n");

        List<IngredientsRange> freshRanges = parseRanges(parts[0]);
        List<Long> availableIds = parseIds(parts[1]);
        return new InventoryDatabase(freshRanges, availableIds);
    }

    private List<Long> parseIds(String ids) {
        List<Long> availableIds = new ArrayList<>();
        for (String id : ids.split("\n")) {
            if (id.isBlank()) continue;
            availableIds.add(Long.parseLong(id.trim()));
        }
        return availableIds;
    }

    private List<IngredientsRange> parseRanges(String ranges) {
        List<IngredientsRange> freshRanges = new ArrayList<>();
        for (String line : ranges.split("\n")) {
            if (line.isBlank()) continue;
            String[] bounds = line.trim().split("-");
            freshRanges.add(new IngredientsRange(Long.parseLong(bounds[0]), Long.parseLong(bounds[1])));
        }
        return freshRanges;
    }
}
