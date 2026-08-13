package software.aoc.day06;

public class Day06Solver {
    private final WorksheetReader reader;
    private final EvaluationStrategy strategy;

    public Day06Solver(WorksheetReader reader, EvaluationStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        Worksheet worksheet = reader.read(input);
        return strategy.evaluate(worksheet);
    }
}
