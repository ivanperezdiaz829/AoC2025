package software.aoc.day12.a;

import software.aoc.Solver;
import software.aoc.day12.BinPackingStrategy;
import software.aoc.day12.ChristmasTreeFarmReader;
import software.aoc.day12.Day12Solver;

public class Day12ASolver implements Solver {
    @Override
    public long solve(String input) {
        ChristmasTreeFarmReader reader = new ChristmasTreeFarmReader();
        BinPackingStrategy strategy = new BacktrackingBinPackingStrategy();
        Day12Solver coreSolver = new Day12Solver(reader, strategy);
        return coreSolver.execute(input);
    }
}
