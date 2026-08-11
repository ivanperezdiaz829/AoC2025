package software.aoc.day04;

public interface AccessRule {
    boolean canAccess(PaperGrid paperGrid, Position position);
}
