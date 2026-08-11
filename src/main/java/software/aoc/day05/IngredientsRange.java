package software.aoc.day05;

public record IngredientsRange(long start, long end) {

    public boolean contains(long id) {
        return start <= id && id <= end;
    }
}
