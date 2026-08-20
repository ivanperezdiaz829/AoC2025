package software.aoc.day07.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07BSolverTest {

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

        Solver solver = new Day07BSolver();
        long result = solver.solve(input);

        assertEquals(40L, result, "El resultado cuántico del ejemplo en la Parte B debería ser 40 líneas temporales");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d07-b", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day07BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 07 Parte B: " + result);
    }
}
