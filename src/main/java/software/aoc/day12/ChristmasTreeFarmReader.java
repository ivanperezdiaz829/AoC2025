package software.aoc.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChristmasTreeFarmReader {

    public ChristmasTreeFarm read(String input) {
        String normalized = input.replace("\r", "");
        String[] blocks = normalized.split("\n\n");
        Map<Integer, PresentShape> catalog = new HashMap<>();

        for (int i = 0; i < blocks.length - 1; i++) {
            String[] lines = blocks[i].split("\n");
            int id = Integer.parseInt(lines[0].replace(":", "").trim());

            List<String> shapeLines = new ArrayList<>();
            for (int j = 1; j < lines.length; j++) {
                if (!lines[j].trim().isEmpty()) { shapeLines.add(lines[j]); }
            }
            catalog.put(id, PresentShape.from(id, shapeLines));
        }

        List<RegionTask> tasks = new ArrayList<>();
        String[] regionLines = blocks[blocks.length - 1].split("\n");

        for (String regionLine : regionLines) {
            if (regionLine.trim().isEmpty()) continue;

            String[] parts = regionLine.split(":");
            String[] dims = parts[0].trim().split("x");
            int width = Integer.parseInt(dims[0]);
            int height = Integer.parseInt(dims[1]);

            String[] counts = parts[1].trim().split("\\s+");
            List<PresentShape> pieces = new ArrayList<>();

            for (int i = 0; i < counts.length; i++) {
                int quantity = Integer.parseInt(counts[i]);
                for (int q = 0; q < quantity; q++) {
                    pieces.add(catalog.get(i));
                }
            }
            tasks.add(new RegionTask(width, height, pieces));
        }
        return new ChristmasTreeFarm(tasks);
    }
}