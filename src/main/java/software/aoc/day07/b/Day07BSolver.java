package software.aoc.day07.b;

import software.aoc.Solver;
import software.aoc.day07.Day07Solver;
import software.aoc.day07.ManifoldReader;
import software.aoc.day07.SimulationStrategy;

public class Day07BSolver implements Solver {
    @Override
    public long solve(String input) {
        ManifoldReader reader = new ManifoldReader();
        SimulationStrategy strategy = new QuantumSimulationStrategy();
        Day07Solver coreSolver = new Day07Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
