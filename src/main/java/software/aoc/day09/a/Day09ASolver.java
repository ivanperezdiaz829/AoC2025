package software.aoc.day09.a;

import software.aoc.Solver;
import software.aoc.day09.Day09Solver;
import software.aoc.day09.RectangleStrategy;
import software.aoc.day09.TheaterFloorReader;

public class Day09ASolver implements Solver {
    @Override
    public long solve(String input) {
        TheaterFloorReader reader = new TheaterFloorReader();
        RectangleStrategy strategy = new TwoCornerRectangleStrategy();
        Day09Solver coreSolver = new Day09Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
