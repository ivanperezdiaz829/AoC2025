package software.aoc.day07;

public class Day07Solver {
    private final ManifoldReader reader;

    public Day07Solver(ManifoldReader reader) {
        this.reader = reader;
    }

    public long execute(String input) {
        TachyonManifold manifold = reader.read(input);
        return manifold.countBeamSlits();
    }
}
