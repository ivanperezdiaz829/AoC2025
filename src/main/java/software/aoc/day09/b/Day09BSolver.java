package software.aoc.day09.b;

import software.aoc.Solver;
import software.aoc.day09.*;

public class Day09BSolver implements Solver {
    @Override
    public long solve(String input) {
        TheaterFloorReader reader = new ObtainTheaterFloor();
        RectangleStrategy strategy = new InteriorRectangleStrategy();
        Day09Solver coreSolver = new Day09Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
