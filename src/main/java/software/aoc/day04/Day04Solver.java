package software.aoc.day04;

import java.util.ArrayList;
import java.util.List;

public class Day04Solver {

    private final GridReader reader;
    private final AccessRule rule;

    public Day04Solver(GridReader reader, AccessRule rule) {
        this.reader = reader;
        this.rule = rule;
    }

    // Parte A
    public long execute(String input) {
        PaperGrid grid = reader.readGrid(input);
        List<int[]> accessibleRolls = findAccessibleRolls(grid);
        return accessibleRolls.size();
    }

    // Parte B
    public long executeSimulation(String input) {
        PaperGrid grid = reader.readGrid(input);
        long totalRemoved = 0;

        while (true) {
            List<int[]> toRemove = findAccessibleRolls(grid);

            if (toRemove.isEmpty()) { break; }
            totalRemoved += toRemove.size();
            grid = grid.removeRolls(toRemove);
        }
        return totalRemoved;
    }

    private List<int[]> findAccessibleRolls(PaperGrid grid) {
        List<int[]> accessible = new ArrayList<>();

        for (int row = 0; row < grid.height(); row++) {
            for (int col = 0; col < grid.width(); col++) {
                if (grid.isRoll(row, col) && rule.canAccess(grid, row, col)) { accessible.add(new int[]{row, col}); }
            }
        }
        return accessible;
    }
}