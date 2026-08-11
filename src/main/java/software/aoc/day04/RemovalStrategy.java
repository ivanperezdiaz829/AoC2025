package software.aoc.day04;

public interface RemovalStrategy {
    long run(PaperGrid paperGrid, AccessRule rule);
}
