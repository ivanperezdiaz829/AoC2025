package software.aoc.day06.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        123 328  51 64\s
         45 64  387 23\s
          6 98  215 314
        *   +   *   + \s
        """;

        Solver solver = new Day06ASolver();
        long result = solver.solve(input);

        assertEquals(4277556L, result, "El resultado del ejemplo en la Parte A debería ser 4277556");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d06-a", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day06ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 06 Parte A: " + result);
    }
}