package software.aoc.day03.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03BSolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
                987654321111111
                811111111111119
                234234234234278
                818181911112111
                """;

        Solver solver = new Day03BSolver();
        long result = solver.solve(input);

        assertEquals(3121910778619L, result, "El resultado del ejemplo en la Parte B debería ser 3121910778619");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d03-a", "battery.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day03BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 03 Parte B: " + result);
    }
}