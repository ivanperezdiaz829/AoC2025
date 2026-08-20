package software.aoc.day07;

import java.util.List;

public record TachyonManifold(List<String> rows, Position startPosition) {

    public long runSimulation(SimulationStrategy strategy) {
        return strategy.simulate(this);
    }
}