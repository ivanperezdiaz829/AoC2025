package software.aoc.day01;
import java.util.List;
import java.util.stream.Collectors;

public class ObtainRotation implements RotationReader {
    @Override
    public List<Rotation> readRotation(String input) {
        return input.lines()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(Rotation::fromString)
                .collect(Collectors.toList());
    }
}