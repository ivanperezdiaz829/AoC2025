package software.aoc.day10;

public class Day10Solver {
    private final MachineReader reader;
    private final ButtonPressStrategy strategy;

    public Day10Solver(MachineReader reader, ButtonPressStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        Factory factory = reader.read(input);
        return factory.calculateMinimumTotalPresses(strategy);
    }
}