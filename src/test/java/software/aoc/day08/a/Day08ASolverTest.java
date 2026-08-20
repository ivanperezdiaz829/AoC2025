package software.aoc.day08.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        162,817,812
        57,618,57
        906,360,560
        592,479,940
        352,342,300
        466,668,158
        542,29,236
        431,825,988
        739,650,466
        52,470,668
        216,146,977
        819,987,18
        117,168,530
        805,96,715
        346,949,466
        970,615,88
        941,993,340
        862,61,35
        984,92,344
        425,690,689
        """;

        Solver solver = new Day08ASolver(10);
        long result = solver.solve(input);

        assertEquals(40L, result, "El resultado del ejemplo en la Parte A debería ser 40 (5 * 4 * 2)");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d08-a", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day08ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 08 Parte A: " + result);
    }
}