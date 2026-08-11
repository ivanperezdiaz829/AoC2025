package software.aoc.day01.a;

import software.aoc.Solver;
import software.aoc.day01.Day01Solver;
import software.aoc.day01.ObtainRotation;
import software.aoc.day01.RotationReader;
import software.aoc.day01.TotalScorer;

public class Day01ASolver implements Solver {
    @Override
    public long solve(String input) {
        RotationReader reader = new ObtainRotation();
        TotalScorer scorer = new EndAtZero();

        Day01Solver coreSolver = new Day01Solver(reader, scorer);
        return coreSolver.execute(input);
    }
}