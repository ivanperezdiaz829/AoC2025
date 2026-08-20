package software.aoc.day07.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        .......S.......
        ...............
        .......^.......
        ...............
        ......^.^......
        ...............
        .....^.^.^.....
        ...............
        ....^.^...^....
        ...............
        ...^.^...^.^...
        ...............
        ..^...^.....^..
        ...............
        .^.^.^.^.^...^.
        ...............
        """;

        Solver solver = new Day07ASolver();
        long result = solver.solve(input);

        assertEquals(21L, result, "El resultado del ejemplo en la Parte A debería ser 21 divisiones");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d07-a", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day07ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 07 Parte A: " + result);
    }
}