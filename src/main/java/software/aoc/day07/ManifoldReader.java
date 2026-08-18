package software.aoc.day07;

import java.util.List;

public class ManifoldReader {
    public TachyonManifold read(String input) {
        List<String> rows = input.lines().toList();
        Position start = findStart(rows);
        return new TachyonManifold(rows, start);
    }

    private Position findStart(List<String> rows) {
        for (int row = 0; row < rows.size(); row++) {
            int col = rows.get(row).indexOf('S');
            if (col != -1) { return new Position(row, col); }
        }
        throw new IllegalStateException("Start S not found");
    }
}

