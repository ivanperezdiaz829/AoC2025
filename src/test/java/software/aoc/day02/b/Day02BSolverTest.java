package software.aoc.day02.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02BSolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124";

        Solver solver = new Day02BSolver();

        long result = solver.solve(input);

        assertEquals(4174379265L, result, "El resultado del ejemplo en la Parte B debería ser 4174379265");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d02-b", "ids.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day02BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 02 Parte B: " + result);
    }
}