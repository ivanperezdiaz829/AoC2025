package software.aoc.day03;

import java.util.List;

public class Day03Solver {

    private final BankReader reader;
    private final JoltageOptimizer optimizer;

    public Day03Solver(BankReader reader, JoltageOptimizer optimizer) {
        this.reader = reader;
        this.optimizer = optimizer;
    }

    public long execute(String input) {
        List<BatteryBank> banks = reader.readBanks(input);

        return banks.stream()
                .mapToLong(optimizer::optimize)
                .sum();
    }
}