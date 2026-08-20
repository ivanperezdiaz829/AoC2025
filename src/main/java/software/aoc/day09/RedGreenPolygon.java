package software.aoc.day09;

import java.util.List;

public record RedGreenPolygon(List<Position2D> vertices) {

    public static RedGreenPolygon of(List<Position2D> vertices) {
        return new RedGreenPolygon(List.copyOf(vertices));
    }

    public boolean contains(Position2D corner1, Position2D corner2) {
        long minX = Math.min(corner1.x(), corner2.x());
        long maxX = Math.max(corner1.x(), corner2.x());
        long minY = Math.min(corner1.y(), corner2.y());
        long maxY = Math.max(corner1.y(), corner2.y());

        if (hasVertexInside(minX, maxX, minY, maxY)) { return false; }
        if (hasEdgeCrossing(minX, maxX, minY, maxY)) { return false; }
        return isInteriorInsidePolygon(minX, maxX, minY, maxY);
    }

    private boolean hasVertexInside(long minX, long maxX, long minY, long maxY) {
        for (Position2D v : vertices) {
            if (v.x() > minX && v.x() < maxX && v.y() > minY && v.y() < maxY) { return true; }
        }
        return false;
    }

    private boolean hasEdgeCrossing(long minX, long maxX, long minY, long maxY) {
        for (int i = 0; i < vertices.size(); i++) {
            Position2D tile1 = vertices.get(i);
            Position2D tile2 = vertices.get((i + 1) % vertices.size());

            if (tile1.y() == tile2.y()) {
                long edgeY = tile1.y();
                long edgeMinX = Math.min(tile1.x(), tile2.x());
                long edgeMaxX = Math.max(tile1.x(), tile2.x());

                if (edgeY > minY && edgeY < maxY) {
                    if (Math.max(minX, edgeMinX) < Math.min(maxX, edgeMaxX)) { return true; }
                }
            } else if (tile1.x() == tile2.x()) {
                long edgeX = tile1.x();
                long edgeMinY = Math.min(tile1.y(), tile2.y());
                long edgeMaxY = Math.max(tile1.y(), tile2.y());

                if (edgeX > minX && edgeX < maxX) {
                    if (Math.max(minY, edgeMinY) < Math.min(maxY, edgeMaxY)) { return true; }
                }
            }
        }
        return false;
    }

    private boolean isInteriorInsidePolygon(long minX, long maxX, long minY, long maxY) {
        if (minX < maxX && minY < maxY) {
            return isPointInside(minX + 0.5, minY + 0.5);
        } else if (minX == maxX && minY < maxY) {
            return isPointInside(minX + 0.1, minY + 0.5) || isPointInside(minX - 0.1, minY + 0.5);
        } else if (minY == maxY && minX < maxX) {
            return isPointInside(minX + 0.5, minY + 0.1) || isPointInside(minX + 0.5, minY - 0.1);
        }
        return true;
    }

    private boolean isPointInside(double qx, double qy) {
        int intersections = 0;
        for (int i = 0; i < vertices.size(); i++) {
            Position2D tile1 = vertices.get(i);
            Position2D tile2 = vertices.get((i + 1) % vertices.size());

            if (tile1.x() == tile2.x()) {
                double edgeX = tile1.x();
                double edgeMinY = Math.min(tile1.y(), tile2.y());
                double edgeMaxY = Math.max(tile1.y(), tile2.y());

                if (qy > edgeMinY && qy < edgeMaxY && edgeX > qx) { intersections++; }
            }
        }
        return (intersections % 2) != 0;
    }
}