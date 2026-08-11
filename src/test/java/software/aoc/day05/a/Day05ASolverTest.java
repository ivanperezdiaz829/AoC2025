package software.aoc.day05.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
                3-5
                10-14
                16-20
                12-18
                
                1
                5
                8
                11
                17
                32
                """;

        Solver solver = new Day05ASolver();
        long result = solver.solve(input);

        assertEquals(3, result, "El resultado del ejemplo debería ser 3");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d05-a", "database.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day05ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 05 Parte A: " + result);
    }
}