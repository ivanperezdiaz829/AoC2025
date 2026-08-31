package software.aoc.day11;

public interface PathCountingStrategy {
    long countPaths(ReactorNetwork reactorNetwork, String start, String end);
}
