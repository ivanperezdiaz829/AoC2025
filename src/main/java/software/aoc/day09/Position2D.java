package software.aoc.day09;

public record Position2D(long x, long y) {

    public long rectangleArea(Position2D position) {
        long height = Math.abs(this.x - position.x) + 1;
        long width = Math.abs(this.y - position.y) + 1;
        return height * width;
    }
}
