package software.aoc.day06;

import java.util.List;

public enum Operator {
    ADD,
    MULTIPLY;

    public static Operator fromSymbol(String symbol) {
        return switch (symbol) {
            case "+" -> ADD;
            case "*" -> MULTIPLY;
            default -> throw new IllegalArgumentException("Unknown operator: " + symbol);
        };
    }

    public long apply(List<Long> operands) {
        if ((operands == null) || operands.isEmpty()) { return 0L; }
        return switch (this) {
            case ADD -> operands.stream().mapToLong(Long::longValue).sum();
            case MULTIPLY -> operands.stream().reduce(1L, (a, b) -> a * b);
        };
    }
}
