package software.aoc.day03.b;

import software.aoc.SafeSolver;
import software.aoc.day03.BankReader;
import software.aoc.day03.Day03Solver;
import software.aoc.day03.JoltageOptimizer;
import software.aoc.day03.ObtainBanks;

public class Day03BSolver implements SafeSolver {

    @Override
    public long solve(String input) {
        BankReader reader = new ObtainBanks();
        JoltageOptimizer optimizer = new MaxTwelveDigitOptimizer();

        Day03Solver coreSolver = new Day03Solver(reader, optimizer);
        return coreSolver.execute(input);
    }
}