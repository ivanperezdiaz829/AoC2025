package software.aoc.day04;

import java.util.List;
import java.util.stream.Collectors;

public record PaperGrid(List<String> rows) {

    public int height() { return rows.size(); }

    public int width() { return rows.isEmpty() ? 0 : rows.getFirst().length(); }

    public boolean isRoll(int row, int col) {
        if (row < 0 || row >= height() || col < 0 || col >= width()) {
            return false;
        }
        return rows.get(row).charAt(col) == '@';
    }

    public PaperGrid removeRolls(List<int[]> rollsToRemove) {
        List<StringBuilder> mutableRows = createMutableRows();

        replaceWithEmptySpaces(mutableRows, rollsToRemove);

        return createNewGridState(mutableRows);
    }

    private List<StringBuilder> createMutableRows() {
        return rows.stream()
                .map(StringBuilder::new)
                .collect(Collectors.toList());
    }

    private void replaceWithEmptySpaces(List<StringBuilder> mutableRows, List<int[]> rollsToRemove) {
        for (int[] coords : rollsToRemove) {
            int row = coords[0];
            int col = coords[1];
            mutableRows.get(row).setCharAt(col, '.');
        }
    }

    private PaperGrid createNewGridState(List<StringBuilder> mutableRows) {
        List<String> finalRows = mutableRows.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());

        return new PaperGrid(finalRows);
    }
}