package software.aoc.day07;

public class Day07Solver {
    private final ManifoldReader reader;
    private final SimulationStrategy strategy;

    public Day07Solver(ManifoldReader reader,  SimulationStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        TachyonManifold manifold = reader.read(input);
        return manifold.runSimulation(strategy);
    }
}
