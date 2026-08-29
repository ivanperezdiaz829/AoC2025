package software.aoc.day10.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
        [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
        [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}
        """;

        Solver solver = new Day10ASolver();
        long result = solver.solve(input);

        assertEquals(7L, result, "El resultado del ejemplo en la Parte A debería ser 7 (2 + 3 + 2)");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d10-a", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day10ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 10 Parte A: " + result);
    }
}