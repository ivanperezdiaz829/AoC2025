package software.aoc.day04.a;

import software.aoc.day04.AccessRule;
import software.aoc.day04.PaperGrid;

public class FewerThanFourAdjacentRule implements AccessRule {
    @Override
    public boolean canAccess(PaperGrid paperGrid, int row, int col) {
        int adjacentRolls = 0;
        for (int diagonalRow = -1; diagonalRow <= 1; diagonalRow++) {
            for (int diagonalCol = -1; diagonalCol <= 1; diagonalCol++) {
                if (diagonalRow == 0 && diagonalCol == 0) continue;
                if (paperGrid.isRoll(row + diagonalRow, col + diagonalCol)) { adjacentRolls++; }
            }
        }
        return adjacentRolls < 4;
    }
}
