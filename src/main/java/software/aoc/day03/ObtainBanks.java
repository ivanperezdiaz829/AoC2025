package software.aoc.day03;

import java.util.List;
import java.util.stream.Collectors;

public class ObtainBanks implements BankReader {

    @Override
    public List<BatteryBank> readBanks(String input) {
        return input.lines()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(BatteryBank::new)
                .collect(Collectors.toList());
    }
}
