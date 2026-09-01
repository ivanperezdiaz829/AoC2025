package software.aoc.day12.a;

import software.aoc.day12.*;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingBinPackingStrategy implements BinPackingStrategy {

    @Override
    public boolean canFit(RegionTask task) {
        List<PresentShape> pieces = new ArrayList<>(task.piecesToPlace());
        long totalArea = pieces.stream().mapToLong(PresentShape::area).sum();
        if (totalArea > (long) task.width() * task.height()) { return false; }

        pieces.sort((a, b) -> Integer.compare(b.area(), a.area()));
        boolean[][] grid = new boolean[task.height()][task.width()];
        return tryPlace(0, pieces, grid, task.width(), task.height());
    }

    private boolean tryPlace(int idx, List<PresentShape> pieces, boolean[][] grid, int w, int h) {
        if (idx == pieces.size()) { return true; }
        PresentShape piece = pieces.get(idx);

        for (ShapeVariation var : piece.variations()) {
            for (int r = 0; r <= h - var.height(); r++) {
                for (int c = 0; c <= w - var.width(); c++) {
                    if (canPlace(grid, var, r, c, w, h)) {
                        place(grid, var, r, c, true);
                        if (tryPlace(idx + 1, pieces, grid, w, h)) { return true; }
                        place(grid, var, r, c, false);
                    }
                }
            }
        }
        return false;
    }

    private boolean canPlace(boolean[][] grid, ShapeVariation var, int r, int c, int w, int h) {
        for (Position2D p : var.points()) {
            int rr = r + p.row();
            int cc = c + p.col();
            if (rr < 0 || rr >= h || cc < 0 || cc >= w || grid[rr][cc]) { return false; }
        }
        return true;
    }

    private void place(boolean[][] grid, ShapeVariation var, int r, int c, boolean val) {
        for (Position2D p : var.points()) {
            grid[r + p.row()][c + p.col()] = val;
        }
    }
}