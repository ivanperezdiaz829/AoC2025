package software.aoc.day06;

public class GrandTotalStrategy implements EvaluationStrategy {
    @Override
    public long evaluate(Worksheet worksheet) {
        return worksheet.problems().stream()
                .mapToLong(MathProblem::evaluate)
                .sum();
    }
}
