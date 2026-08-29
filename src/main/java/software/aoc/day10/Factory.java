package software.aoc.day10;

import java.util.List;

public record Factory(List<Machine> machines) {

    public long calculateMinimumTotalPresses(ButtonPressStrategy strategy) {
        return machines.stream()
                .mapToLong(strategy::findMinimumPresses)
                .sum();
    }
}

