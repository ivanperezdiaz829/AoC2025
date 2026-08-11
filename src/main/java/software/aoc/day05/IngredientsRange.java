package software.aoc.day05;

public record IngredientsRange(long start, long end) {
    public boolean contains(long id) {
        return id >= start && id <= end;
    }

    public boolean overlaps(IngredientsRange other) {
        return other.start() <= this.end;
    }

    public IngredientsRange merge(IngredientsRange other) {
        return new IngredientsRange(this.start, Math.max(this.end, other.end()));
    }

    public long length() {
        return end - start + 1;
    }
}