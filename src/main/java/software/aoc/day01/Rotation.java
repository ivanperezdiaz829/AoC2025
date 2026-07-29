package software.aoc.day01;

public record Rotation(char direction, int steps) {
    public static Rotation fromString(String raw) {
        return new Rotation(raw.charAt(0), Integer.parseInt(raw.substring(1)));
    }
}