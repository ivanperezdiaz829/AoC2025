package software.aoc.day04.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04BSolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
                ..@@.@@@@.
                @@@.@.@.@@
                @@@@@.@.@@
                @.@@@@..@.
                @@.@@@@.@@
                .@@@@@@@.@
                .@.@.@.@@@
                @.@@@.@@@@
                .@@@@@@@@.
                @.@.@@@.@.
                """;

        Solver solver = new Day04BSolver();
        long result = solver.solve(input);

        assertEquals(43, result, "El resultado del ejemplo en la Parte B debería ser 43");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d04-a", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day04BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 04 Parte B: " + result);
    }
}