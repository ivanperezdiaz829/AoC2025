package software.aoc.day01.b;

import org.junit.jupiter.api.Test;
import software.aoc.SafeSolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01BSolverTest {

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

        SafeSolver solver = new Day01BSolver();
        long result = solver.solve(input);

        assertEquals(6, result, "El resultado del ejemplo en la Parte B debería ser 6");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d01-b", "orders.txt");
        String input = Files.readString(inputPath);

        SafeSolver solver = new Day01BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 01 Parte B: " + result);
    }
}