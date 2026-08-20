package software.aoc.day07.a;

import software.aoc.day07.Position;
import software.aoc.day07.SimulationStrategy;
import software.aoc.day07.TachyonManifold;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassicalSimulationStrategy implements SimulationStrategy {

    @Override
    public long simulate(TachyonManifold manifold) {
        List<String> rows = manifold.rows();
        Position start = manifold.startPosition();
        Set<Integer> activeCols = new HashSet<>();
        activeCols.add(start.col());

        int width = rows.getFirst().length();
        long totalBeamSplits = 0;

        for (int row = start.row(); row < rows.size(); row++) {
            String currentRow = rows.get(row);
            Set<Integer> nextCols = new HashSet<>();

            for (int col : activeCols) {
                if (col < 0 || col >= width) { continue; }
                if (currentRow.charAt(col) == '^') {
                    totalBeamSplits++;
                    nextCols.add(col - 1);
                    nextCols.add(col + 1);
                } else { nextCols.add(col); }
            }
            activeCols = nextCols;
        }
        return totalBeamSplits;
    }
}