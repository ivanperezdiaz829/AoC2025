package software.aoc.day11.b;

import software.aoc.day11.PathCountingStrategy;
import software.aoc.day11.PathQuery;
import software.aoc.day11.ReactorNetwork;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MandatoryNodesPathCountingStrategy implements PathCountingStrategy {

    private final List<String> mandatoryNodes;
    private final int targetMask;

    public MandatoryNodesPathCountingStrategy(List<String> mandatoryNodes) {
        this.mandatoryNodes = List.copyOf(mandatoryNodes);
        this.targetMask = (1 << this.mandatoryNodes.size()) - 1;
    }

    @Override
    public long countPaths(ReactorNetwork network, PathQuery query) {
        Map<State, Long> memo = new HashMap<>();
        int initialMask = calculateMask(query.start(), 0);
        return dfs(query.start(), query, network.adjacencyList(), initialMask, memo);
    }

    private long dfs(String current, PathQuery query, Map<String, List<String>> adjList, int visitedMask, Map<State, Long> memo) {
        if (current.equals(query.end())) { return (visitedMask == targetMask) ? 1L : 0L; }
        State stateKey = new State(current, visitedMask);
        if (memo.containsKey(stateKey)) { return memo.get(stateKey); }
        long count = 0;
        List<String> neighbors = adjList.getOrDefault(current, Collections.emptyList());

        for (String neighbor : neighbors) {
            int nextMask = calculateMask(neighbor, visitedMask);
            count += dfs(neighbor, query, adjList, nextMask, memo);
        }
        memo.put(stateKey, count);
        return count;
    }

    private int calculateMask(String node, int currentMask) {
        for (int i = 0; i < mandatoryNodes.size(); i++) {
            if (mandatoryNodes.get(i).equals(node)) {
                return currentMask | (1 << i);
            }
        }
        return currentMask;
    }
    private record State(String node, int visitedMask) {}
}
