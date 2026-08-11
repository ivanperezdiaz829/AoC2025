package software.aoc.day04.a;

import software.aoc.day04.AccessRule;
import software.aoc.day04.PaperGrid;
import software.aoc.day04.Position;

public class FewerThanFourAdjacentRule implements AccessRule {

    @Override
    public boolean canAccess(PaperGrid grid, Position position) {
        int adjacentRolls = 0;

        for (int diagonalRow = -1; diagonalRow <= 1; diagonalRow++) {
            for (int diagonalCol = -1; diagonalCol <= 1; diagonalCol++) {
                if (diagonalRow == 0 && diagonalCol == 0) continue;
                Position neighbor = new Position(position.row() + diagonalRow, position.col() + diagonalCol);
                if (grid.isRoll(neighbor)) { adjacentRolls++; }
            }
        }
        return adjacentRolls < 4;
    }
}