package software.aoc.day09;

public class Day09Solver {
    private final TheaterFloorReader reader;
    private final RectangleStrategy strategy;

    public Day09Solver(TheaterFloorReader reader, RectangleStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        TheaterFloor floor = reader.read(input);
        return floor.calculateLargestArea(strategy);
    }
}
