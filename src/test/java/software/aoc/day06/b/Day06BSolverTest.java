package software.aoc.day06.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06BSolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        123 328  51 64\s
         45 64  387 23\s
          6 98  215 314
        *   +   *   + \s
        """;

        Solver solver = new Day06BSolver();
        long result = solver.solve(input);

        assertEquals(3263827L, result, "El resultado del ejemplo en la Parte B debería ser 3263827");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d06-b", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day06BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 06 Parte B: " + result);
    }
}