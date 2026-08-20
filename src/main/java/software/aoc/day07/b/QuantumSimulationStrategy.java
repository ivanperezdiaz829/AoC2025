package software.aoc.day07.b;

import software.aoc.day07.Position;
import software.aoc.day07.SimulationStrategy;
import software.aoc.day07.TachyonManifold;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuantumSimulationStrategy implements SimulationStrategy {

    @Override
    public long simulate(TachyonManifold manifold) {
        List<String> rows = manifold.rows();
        Position start = manifold.startPosition();
        Map<Integer, Long> activeTimelines = new HashMap<>();
        activeTimelines.put(start.col(), 1L);

        int width = rows.getFirst().length();
        long exitedTimelines = 0;

        for (int row = start.row(); row < rows.size(); row++) {
            String currentRow = rows.get(row);
            Map<Integer, Long> nextTimelines = new HashMap<>();

            for (Map.Entry<Integer, Long> entry : activeTimelines.entrySet()) {
                int col = entry.getKey();
                long count = entry.getValue();
                if (col < 0 || col >= width) {
                    exitedTimelines += count;
                    continue;
                }
                if (currentRow.charAt(col) == '^') {
                    nextTimelines.merge(col - 1, count, Long::sum);
                    nextTimelines.merge(col + 1, count, Long::sum);
                } else { nextTimelines.merge(col, count, Long::sum); }
            }
            activeTimelines = nextTimelines;
        }
        long activeAtBottom = activeTimelines.values().stream().mapToLong(Long::longValue).sum();
        return exitedTimelines + activeAtBottom;
    }
}