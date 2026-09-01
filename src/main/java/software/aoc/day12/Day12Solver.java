package software.aoc.day12;

public class Day12Solver {
    private final ChristmasTreeFarmReader reader;
    private final BinPackingStrategy strategy;

    public Day12Solver(ChristmasTreeFarmReader reader,  BinPackingStrategy strategy) {
        this.reader = reader;
        this.strategy = strategy;
    }

    public long execute(String input) {
        ChristmasTreeFarm farm = reader.read(input);
        return farm.countFittableRegions(strategy);
    }
}
