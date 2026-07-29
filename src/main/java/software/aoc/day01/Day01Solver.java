package software.aoc.day01;

import java.util.List;

public class Day01Solver {

    private final RotationReader reader;
    private final TotalScorer scorer;

    public Day01Solver(RotationReader reader, TotalScorer scorer) {
        this.reader = reader;
        this.scorer = scorer;
    }

    public long execute(String input) {
        List<Rotation> instructions = reader.readRotation(input);
        Dial currentDial = new Dial(50);
        long totalScore = 0;

        for (Rotation instruction : instructions) {
            Dial oldDial = currentDial;
            currentDial = oldDial.rotate(instruction);

            totalScore += scorer.calculateScore(oldDial, currentDial, instruction);
        }
        return totalScore;
    }
}