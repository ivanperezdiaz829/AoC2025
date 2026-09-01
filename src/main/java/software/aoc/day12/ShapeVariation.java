package software.aoc.day12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record ShapeVariation(int width, int height, List<Position2D> points) {

    public static ShapeVariation normalize(List<Position2D> rawPoints) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        for (Position2D point : rawPoints) {
            minRow = Math.min(minRow, point.row());
            maxRow = Math.max(maxRow, point.row());
            minCol = Math.min(minCol, point.col());
            maxCol = Math.max(maxCol, point.col());
        }

        List<Position2D> normalizedPoints = new ArrayList<>();
        for (Position2D point : rawPoints) {
            normalizedPoints.add(new Position2D(point.row() - minRow, point.col() - minCol));
        }
        normalizedPoints.sort(Comparator.comparingInt(Position2D::row).thenComparingInt(Position2D::col));
        return new ShapeVariation(maxCol - minCol + 1, maxRow - minRow + 1, List.copyOf(normalizedPoints));
    }

    public ShapeVariation rotate() {
        List<Position2D> rotatedPoints = new ArrayList<>();
        for (Position2D point : points) {
            rotatedPoints.add(new Position2D(point.col(), height - 1 - point.row()));
        }
        return normalize(rotatedPoints);
    }

    public ShapeVariation flip() {
        List<Position2D> flippedPoints = new ArrayList<>();
        for (Position2D point : points) {
            flippedPoints.add(new Position2D(point.row(), width - 1 - point.col()));
        }
        return normalize(flippedPoints);
    }
}