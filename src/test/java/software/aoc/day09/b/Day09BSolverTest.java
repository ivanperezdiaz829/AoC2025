package software.aoc.day09.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09BSolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        7,1
        11,1
        11,7
        9,7
        9,5
        2,5
        2,3
        7,3
        """;

        Solver solver = new Day09BSolver();
        long result = solver.solve(input);

        assertEquals(24L, result, "El resultado del ejemplo en la Parte B debería ser 24");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d09-b", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day09BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 09 Parte B: " + result);
    }
}