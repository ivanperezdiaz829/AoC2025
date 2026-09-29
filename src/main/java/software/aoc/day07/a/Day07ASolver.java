package software.aoc.day07.a;

import software.aoc.Solver;
import software.aoc.day07.Day07Solver;
import software.aoc.day07.ManifoldReader;
import software.aoc.day07.ObtainManifold;
import software.aoc.day07.SimulationStrategy;

public class Day07ASolver implements Solver {
    @Override
    public long solve(String input) {
        ManifoldReader reader = new ObtainManifold();
        SimulationStrategy strategy = new ClassicalSimulationStrategy();
        Day07Solver coreSolver = new Day07Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
