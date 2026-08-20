package software.aoc.day08;

import java.util.ArrayList;
import java.util.List;

public class PlaygroundReader {

    public Playground read(String input) {
        List<JunctionBox> junctionBoxes = new ArrayList<>();
        String[] lines = input.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) { continue; }

            String[] parts = line.split(",");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            long z = Long.parseLong(parts[2]);
            junctionBoxes.add(new JunctionBox(i, new Position3D(x, y, z)));
        }
        return new Playground(junctionBoxes);
    }
}
