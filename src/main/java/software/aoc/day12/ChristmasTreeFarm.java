package software.aoc.day12;

import java.util.List;

public record ChristmasTreeFarm(List<RegionTask> tasks) {
    public long countFittableRegions(BinPackingStrategy strategy) {
        return tasks.stream()
                .filter(strategy::canFit)
                .count();
    }
}
