package software.aoc.day07;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record TachyonManifold(List<String> rows, Position startPosition) {
    public long countBeamSlits() {
        long totalBeamSlits = 0;
        int width = rows.getFirst().length();
        Set<Integer> activeCols = new HashSet<>();
        activeCols.add(startPosition.col());

        for (int row = startPosition.row(); row < rows.size(); row++) {
            String currentRow = rows.get(row);
            Set<Integer> nextCols = new HashSet<>();
            for (int col : activeCols) {
                if (col < 0 || col >= width) { continue; }
                if (currentRow.charAt(col) == '^') {
                    totalBeamSlits++;
                    nextCols.add(col - 1);
                    nextCols.add(col + 1);
                } else { nextCols.add(col); }
                activeCols = nextCols;
            }
        }
        return totalBeamSlits;
    }
}
