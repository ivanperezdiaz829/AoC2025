package software.aoc.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record PaperGrid(List<String> rows) {

    public int height() { return rows.size(); }

    public int width() { return rows.isEmpty() ? 0 : rows.getFirst().length(); }

    public boolean isRoll(Position position) {
        int row = position.row();
        int col = position.col();
        if (row < 0 || row >= height() || col < 0 || col >= width()) { return false; }
        return rows.get(row).charAt(col) == '@';
    }

    public List<Position> findAccessibleRolls(AccessRule rule) {
        List<Position> accessible = new ArrayList<>();
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
                Position position = new Position(row, col);
                if (isRoll(position) && rule.canAccess(this, position)) { accessible.add(position); }
            }
        }
        return accessible;
    }

    public PaperGrid removeRolls(List<Position> rollsToRemove) {
        List<StringBuilder> mutableRows = createMutableRows();
        replaceWithEmptySpaces(mutableRows, rollsToRemove);
        return createNewGridState(mutableRows);
    }

    private List<StringBuilder> createMutableRows() {
        return rows.stream()
                .map(StringBuilder::new)
                .collect(Collectors.toList());
    }

    private void replaceWithEmptySpaces(List<StringBuilder> mutableRows, List<Position> rollsToRemove) {
        for (Position pos : rollsToRemove) {
            mutableRows.get(pos.row()).setCharAt(pos.col(), '.');
        }
    }

    private PaperGrid createNewGridState(List<StringBuilder> mutableRows) {
        List<String> finalRows = mutableRows.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
        return new PaperGrid(finalRows);
    }
}