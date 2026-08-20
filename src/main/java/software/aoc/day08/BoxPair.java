package software.aoc.day08;

public record BoxPair(JunctionBox box1, JunctionBox box2, long distance) implements Comparable<BoxPair> {
    @Override
    public int compareTo(BoxPair other) {
        return Long.compare(this.distance, other.distance);
    }
}
