package software.aoc.day03.b;

import software.aoc.Solver;
import software.aoc.day03.BankReader;
import software.aoc.day03.Day03Solver;
import software.aoc.day03.JoltageOptimizer;
import software.aoc.day03.ObtainBanks;

public class Day03BSolver implements Solver {

    @Override
    public long solve(String input) {
        BankReader reader = new ObtainBanks();
        JoltageOptimizer optimizer = new MaxTwelveDigitOptimizer();

        Day03Solver coreSolver = new Day03Solver(reader, optimizer);
        return coreSolver.execute(input);
    }
}