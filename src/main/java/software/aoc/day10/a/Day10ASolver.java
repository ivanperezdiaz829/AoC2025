package software.aoc.day10.a;

import software.aoc.Solver;
import software.aoc.day10.ButtonPressStrategy;
import software.aoc.day10.Day10Solver;
import software.aoc.day10.MachineReader;

public class Day10ASolver implements Solver {
    @Override
    public long solve(String input) {
        MachineReader reader = new MachineReader();
        ButtonPressStrategy strategy = new BFSButtonPressStrategy();
        Day10Solver coreSolver = new Day10Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
