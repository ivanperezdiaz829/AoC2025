package software.aoc.day09;

import java.util.ArrayList;
import java.util.List;

public class TheaterFloorReader {
    public TheaterFloor read(String input) {
        List<Position2D> tiles = new ArrayList<>();
        String[] lines = input.split("\n");

        for (String line : lines) {
            String trimmedLine = line.trim();
            if (trimmedLine.isEmpty()) { continue; }

            String[] parts = trimmedLine.split(",");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            tiles.add(new Position2D(x, y));
        }
        return new TheaterFloor(tiles);
    }
}
