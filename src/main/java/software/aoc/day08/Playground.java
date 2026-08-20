package software.aoc.day08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record Playground(List<JunctionBox> boxes) {
    public long calculateCircuitScore(ConnectionStrategy strategy) {
        List<BoxPair> pairs = new ArrayList<>();
        for (int i = 0; i < boxes.size(); i++) {
            for (int j = i + 1; j < boxes.size(); j++) {
                JunctionBox box1 = boxes.get(i);
                JunctionBox box2 = boxes.get(j);
                long dist = box1.position().distance(box2.position());
                pairs.add(new BoxPair(box1, box2, dist));
            }
        }
        pairs.sort(Comparator.comparingLong(BoxPair::distance));
        List<Integer> circuitSize = strategy.applyConnections(boxes.size(), pairs);
        return circuitSize.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToLong(Integer::longValue)
                .reduce(1L, (a, b) -> a * b);
    }
}
