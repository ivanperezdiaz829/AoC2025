package software.aoc.day03.a;

import software.aoc.day03.BatteryBank;
import software.aoc.day03.JoltageOptimizer;

public class MaxTwoDigitOptimizer implements JoltageOptimizer {
    @Override
    public long optimize(BatteryBank batteryBank) {
        String ratings = batteryBank.ratings();
        long maxJoltage = 0;

        for (int i = 0; i < ratings.length() - 1; i++) {
            int digit1 = ratings.charAt(i) - '0';
            for  (int j = i + 1; j < ratings.length(); j++) {
                int digit2 = ratings.charAt(j) - '0';
                int currentJoltage = (digit1 * 10) + digit2;
                if (currentJoltage > maxJoltage) { maxJoltage = currentJoltage; }
                if (maxJoltage == 99) { return 99; }
            }
        }
        return maxJoltage;
    }
}
