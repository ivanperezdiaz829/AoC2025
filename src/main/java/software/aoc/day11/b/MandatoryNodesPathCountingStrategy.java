package software.aoc.day11.b;

import software.aoc.day11.PathCountingStrategy;
import software.aoc.day11.PathQuery;
import software.aoc.day11.ReactorNetwork;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MandatoryNodesPathCountingStrategy implements PathCountingStrategy {

    private final String mandatory1;
    private final String mandatory2;

    public MandatoryNodesPathCountingStrategy(String mandatory1, String mandatory2) {
        this.mandatory1 = mandatory1;
        this.mandatory2 = mandatory2;
    }

    @Override
    public long countPaths(ReactorNetwork reactorNetwork, PathQuery query) {
        Map<State, Long> memo = new HashMap<>();
        boolean startV1 = query.start().equals(mandatory1);
        boolean startV2 = query.start().equals(mandatory2);
        return dfs(query.start(), query.end(), reactorNetwork.adjacencyList(), startV1, startV2, memo);
    }

    private long dfs(String current, String target, Map<String, List<String>> adjList, boolean visited1, boolean visited2, Map<State, Long> memo) {
        if (current.equals(target)) { return (visited1 && visited2) ? 1L : 0L; }

        State stateKey = new State(current, visited1, visited2);
        if (memo.containsKey(stateKey)) { return memo.get(stateKey); }

        long count = 0;
        List<String> neighbors = adjList.getOrDefault(current, Collections.emptyList());
        for (String neighbor : neighbors) {
            boolean nextV1 = visited1 || neighbor.equals(mandatory1);
            boolean nextV2 = visited2 || neighbor.equals(mandatory2);
            count += dfs(neighbor, target, adjList, nextV1, nextV2, memo);
        }
        memo.put(stateKey, count);
        return count;
    }

    private record State(String node, boolean visited1, boolean visited2) {}
}
