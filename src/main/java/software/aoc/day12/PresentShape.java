package software.aoc.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record PresentShape(int id, int area, Set<ShapeVariation> variations) {

    public static PresentShape from(int id, List<String> lines) {
        List<Position2D> points = new ArrayList<>();
        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);
            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == '#') { points.add(new Position2D(row, col)); }
            }
        }

        ShapeVariation base = ShapeVariation.normalize(points);
        Set<ShapeVariation> variations = new HashSet<>();
        ShapeVariation current = base;

        for (int i = 0; i < 4; i++) {
            variations.add(current);
            variations.add(current.flip());
            current = current.rotate();
        }
        return new PresentShape(id, points.size(), Set.copyOf(variations));
    }
}