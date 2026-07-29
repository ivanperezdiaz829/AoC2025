package software.aoc.day01;

public record Dial(int position) {

    private static final int TOTAL_POSITIONS = 100;

    public Dial rotate(Rotation rotation) {
        int delta = (rotation.direction() == 'R') ? rotation.steps() : -rotation.steps();
        int rawPosition = (this.position + delta) % TOTAL_POSITIONS;
        int newPosition = (rawPosition + TOTAL_POSITIONS) % TOTAL_POSITIONS;
        return new Dial(newPosition);
    }
}
