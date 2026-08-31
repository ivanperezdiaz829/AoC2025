package software.aoc.day11;

import java.util.List;
import java.util.Map;

public record ReactorNetwork(Map<String, List<String>> adjacencyList) {
    public long countPathsFrom(PathQuery query, PathCountingStrategy strategy){
        return strategy.countPaths(this, query);
    }
}
