package software.aoc.day06;

import java.util.List;

public record MathProblem(List<Long> operands, Operator operator) {
    public long evaluate() {
        return operator.apply(operands);
    }
}
