package software.aoc.day11.a;

import software.aoc.day11.PathCountingStrategy;
import software.aoc.day11.PathQuery;
import software.aoc.day11.ReactorNetwork;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoizedDFSPathCountingStrategy implements PathCountingStrategy {
    @Override
    public long countPaths(ReactorNetwork reactorNetwork, PathQuery query) {
        Map<String, Long> memo =  new HashMap<>();
        return dfs(query.start(), query.end(), reactorNetwork.adjacencyList(), memo);
    }

    private long dfs(String current, String target, Map<String, List<String>> adjList, Map<String, Long> memo) {
        if (current.equals(target)) { return 1L; }
        if (memo.containsKey(current)) { return memo.get(current); }
        long count = 0;
        List<String> neighbours = adjList.getOrDefault(current, Collections.emptyList());
        for (String neighbour : neighbours) {
            count += dfs(neighbour, target, adjList, memo);
        }
        memo.put(current, count);
        return count;
    }
}
