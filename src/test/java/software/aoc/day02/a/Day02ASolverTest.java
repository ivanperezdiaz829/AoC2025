package software.aoc.day02.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124";

        Solver solver = new Day02ASolver();
        long result = solver.solve(input);

        assertEquals(1227775554L, result, "El resultado del ejemplo debería ser 1227775554");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d02-a", "ids.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day02ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 02 Parte A: " + result);
    }
}