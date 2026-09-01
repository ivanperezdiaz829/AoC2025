package software.aoc.day12.a;

import org.junit.jupiter.api.Test;
import software.aoc.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12ASolverTest {

    @Test
    void shouldSolveExampleCorrectly() {
        String input = """
        0:
        ###
        ##.
        ##.
        
        1:
        ###
        ##.
        .##
        
        2:
        .##
        ###
        ##.
        
        3:
        ##.
        ###
        ##.
        
        4:
        ###
        #..
        ###
        
        5:
        ###
        .#.
        ###
        
        4x4: 0 0 0 0 2 0
        12x5: 1 0 1 0 2 2
        12x5: 1 0 1 0 3 2
        """;

        Solver solver = new Day12ASolver();
        long result = solver.solve(input);

        assertEquals(2L, result, "El resultado del ejemplo en la Parte A debería ser 2 regiones válidas");
    }

    @Test
    void shouldSolveRealInput() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "d12-a", "input.txt");
        String input = Files.readString(inputPath);

        Solver solver = new Day12ASolver();
        long result = solver.solve(input);

        System.out.println("Solución Día 12 Parte A: " + result);
    }
}
