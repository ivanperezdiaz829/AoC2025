package software.aoc.day03.a;

import org.junit.jupiter.api.Test;
import software.aoc.SafeSolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
                987654321111111
                811111111111119
                234234234234278
                818181911112111
                """;

        SafeSolver solver = new Day03ASolver();
        long result = solver.solve(input);

        assertEquals(357, result, "El resultado del ejemplo debería ser 357");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d03-a", "battery.txt");
        String input = Files.readString(inputPath);

        SafeSolver solver = new Day03ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 03 Parte A: " + result);
    }
}