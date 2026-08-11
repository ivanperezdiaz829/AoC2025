package software.aoc.day01.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
                L68
                L30
                R48
                L5
                R60
                L55
                L1
                L99
                R14
                L82
                """;

        Solver solver = new Day01ASolver();
        long result = solver.solve(input);

        assertEquals(3, result, "El resultado del ejemplo debería ser 3");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d01-a", "orders.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day01ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 01 Parte A: " + result);
    }
}