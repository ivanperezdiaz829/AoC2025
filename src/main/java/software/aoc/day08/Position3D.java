package software.aoc.day08;

public record Position3D(long x, long y, long z) {
    public long distance(Position3D dist) {
        long distX = x - dist.x;
        long distY = y - dist.y;
        long distZ = z - dist.z;
        return (distX * distX) + (distY * distY) + (distZ * distZ);
    }
}
