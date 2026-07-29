package software.aoc.day01.b;

import software.aoc.day01.Dial;
import software.aoc.day01.Rotation;
import software.aoc.day01.TotalScorer;

public class PassThroughZero implements TotalScorer {

    @Override
    public int calculateScore(Dial oldDial, Dial newDial, Rotation rotation) {
        int start = oldDial.position();
        int steps = rotation.steps();

        if (steps == 0) return 0;

        if (rotation.direction() == 'R') {
            return (start + steps) / 100;
        } else {
            int distanceToZero = (start == 0) ? 100 : start;
            if (steps < distanceToZero) return 0;
            return 1 + ((steps - distanceToZero) / 100);
        }
    }
}