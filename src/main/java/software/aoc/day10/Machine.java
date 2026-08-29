package software.aoc.day10;

import java.util.List;

public record Machine(int targetMask, int numLights, List<Button> buttons, List<Integer> joltages) {
}
