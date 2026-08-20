package software.aoc.day09.a;

import software.aoc.day09.Position2D;
import software.aoc.day09.RectangleStrategy;

import java.util.List;

public class TwoCornerRectangleStrategy implements RectangleStrategy {

    @Override
    public long findLargestArea(List<Position2D> tiles) {
        long maxArea = 0;

        for (int i = 0; i < tiles.size(); i++) {
            for (int j = i + 1; j < tiles.size(); j++) {
                Position2D tile1 = tiles.get(i);
                Position2D tile2 = tiles.get(j);
                long currentArea = tile1.rectangleArea(tile2);
                if (currentArea > maxArea) { maxArea = currentArea; }
            }
        }
        return maxArea;
    }
}
