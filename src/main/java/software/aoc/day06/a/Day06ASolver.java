package software.aoc.day06.a;

import software.aoc.Solver;
import software.aoc.day06.*;

public class Day06ASolver implements Solver {
    @Override
    public long solve(String input) {
        WorksheetReader reader = new VerticalWorksheetReader();
        EvaluationStrategy strategy = new GrandTotalStrategy();

        Day06Solver coreSolver = new Day06Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
