package software.aoc.day09;

import java.util.List;

public record TheaterFloor(List<Position2D> redTiles) {

    public long calculateLargestArea(RectangleStrategy strategy) {
        return strategy.findLargestArea(this.redTiles);
    }
}
