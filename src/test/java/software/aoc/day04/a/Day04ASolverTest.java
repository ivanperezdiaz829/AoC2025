package software.aoc.day04.a;

import org.junit.jupiter.api.Test;
import software.aoc.SafeSolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04ASolverTest {

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

        SafeSolver solver = new Day04ASolver();
        long result = solver.solve(input);

        assertEquals(13, result, "El resultado del ejemplo debería ser 13");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d04-a", "input.txt");
        String input = Files.readString(inputPath);

        SafeSolver solver = new Day04ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 04 Parte A: " + result);
    }
}