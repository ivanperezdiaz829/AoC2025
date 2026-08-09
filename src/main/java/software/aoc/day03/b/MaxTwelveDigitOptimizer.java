package software.aoc.day03.b;

import software.aoc.day03.BatteryBank;
import software.aoc.day03.JoltageOptimizer;

public class MaxTwelveDigitOptimizer implements JoltageOptimizer {

    private static final int TARGET_LENGTH = 12;

    @Override
    public long optimize(BatteryBank bank) {
        String ratings = bank.ratings();
        StringBuilder result = new StringBuilder();

        int start = 0;

        for (int i = 0; i < TARGET_LENGTH; i++) {
            int end = ratings.length() - TARGET_LENGTH + i;
            char maxChar = '0' - 1;
            int maxIdx = -1;
            for (int j = start; j <= end; j++) {
                if (ratings.charAt(j) > maxChar) {
                    maxChar = ratings.charAt(j);
                    maxIdx = j;
                }
            }
            result.append(maxChar);
            start = maxIdx + 1;
        }
        return Long.parseLong(result.toString());
    }
}

