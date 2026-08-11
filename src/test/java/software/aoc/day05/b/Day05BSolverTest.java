package software.aoc.day05.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05BSolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
                3-5
                10-14
                16-20
                12-18
                
                1
                5
                """;

        Solver solver = new Day05BSolver();
        long result = solver.solve(input);

        assertEquals(14, result, "El resultado del ejemplo en la Parte B debería ser 14");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d05-b", "database.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day05BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 05 Parte B: " + result);
    }
}