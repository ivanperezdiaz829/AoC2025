package software.aoc.day04;

public interface AccessRule {
    boolean canAccess(PaperGrid paperGrid, int row, int col);
}
