package software.aoc.day01.a;

import software.aoc.day01.Dial;
import software.aoc.day01.Rotation;
import software.aoc.day01.TotalScorer;

public class EndAtZero implements TotalScorer {
    @Override
    public int calculateScore(Dial oldDial, Dial newDial, Rotation rotation) {
        return newDial.position() == 0 ? 1 : 0;
    }
}