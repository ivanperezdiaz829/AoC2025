package software.aoc.day11.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        aaa: you hhh
        you: bbb ccc
        bbb: ddd eee
        ccc: ddd eee fff
        ddd: ggg
        eee: out
        fff: out
        ggg: out
        hhh: ccc fff iii
        iii: out
        """;

        Solver solver = new Day11ASolver();
        long result = solver.solve(input);

        assertEquals(5L, result, "El resultado del ejemplo en la Parte A debería ser 5 caminos únicos");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d11-a", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day11ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 11 Parte A: " + result);
    }
}
