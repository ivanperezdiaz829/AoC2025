package software.aoc.day11.b;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11BSolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        svr: aaa bbb
        aaa: fft
        fft: ccc
        bbb: tty
        tty: ccc
        ccc: ddd eee
        ddd: hub
        hub: fff
        eee: dac
        dac: fff
        fff: ggg hhh
        ggg: out
        hhh: out
        """;

        Solver solver = new Day11BSolver();
        long result = solver.solve(input);

        assertEquals(2L, result, "El resultado del ejemplo en la Parte B debería ser 2 caminos únicos");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d11-b", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day11BSolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 11 Parte B: " + result);
    }
}