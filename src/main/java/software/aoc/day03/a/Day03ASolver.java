package software.aoc.day03.a;

import software.aoc.SafeSolver;
import software.aoc.day03.BankReader;
import software.aoc.day03.Day03Solver;
import software.aoc.day03.JoltageOptimizer;
import software.aoc.day03.ObtainBanks;

public class Day03ASolver implements SafeSolver {

    @Override
    public long solve(String input) {
        BankReader reader = new ObtainBanks();
        JoltageOptimizer optimizer = new MaxTwoDigitOptimizer();

        Day03Solver coreSolver = new Day03Solver(reader, optimizer);
        return coreSolver.execute(input);
    }
}