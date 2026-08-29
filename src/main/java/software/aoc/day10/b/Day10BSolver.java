package software.aoc.day10.b;

import software.aoc.Solver;
import software.aoc.day10.*;

public class Day10BSolver implements Solver {
    @Override
    public long solve(String input) {
        MachineReader reader = new MachineReader();
        ButtonPressStrategy strategy = new LinearSystemButtonPressStrategy();
        Day10Solver coreSolver = new Day10Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
