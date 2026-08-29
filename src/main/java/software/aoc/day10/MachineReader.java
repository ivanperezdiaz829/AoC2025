package software.aoc.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MachineReader {

    private static final Pattern BUTTONS_PATTERN = Pattern.compile("\\((.*?)\\)");
    private static final Pattern JOLTAGES_PATTERN = Pattern.compile("\\{(.*?)\\}");

    public Factory read(String input) {
        List<Machine> machines = input.lines()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(this::parseMachine)
                .toList();
        return new Factory(machines);
    }

    private Machine parseMachine(String line) {
        Target target = extractTarget(line);
        List<Button> buttons = extractButtons(line);
        List<Integer> joltages = extractJoltages(line);
        return new Machine(target.mask(), target.numLights(), buttons, joltages);
    }

    private Target extractTarget(String line) {
        int bracketStart = line.indexOf('[');
        int bracketEnd = line.indexOf(']');

        if (bracketStart == -1 || bracketEnd == -1) {
            throw new IllegalArgumentException("The objective state could not be found: " + line);
        }
        String targetStr = line.substring(bracketStart + 1, bracketEnd);
        int targetMask = 0;

        for (int i = 0; i < targetStr.length(); i++) {
            if (targetStr.charAt(i) == '#') { targetMask |= (1 << i); }
        }
        return new Target(targetMask, targetStr.length());
    }

    private List<Button> extractButtons(String line) {
        List<Button> buttons = new ArrayList<>();
        Matcher matcher = BUTTONS_PATTERN.matcher(line);

        while (matcher.find()) {
            String btnContent = matcher.group(1);
            int toggleMask = 0;
            if (!btnContent.isEmpty()) {
                for (String num : btnContent.split(",")) {
                    toggleMask |= (1 << Integer.parseInt(num.trim()));
                }
            }
            buttons.add(new Button(toggleMask));
        }
        return buttons;
    }

    private List<Integer> extractJoltages(String line) {
        List<Integer> joltages = new ArrayList<>();
        Matcher matcher = JOLTAGES_PATTERN.matcher(line);

        if (matcher.find()) {
            String joltContent = matcher.group(1);
            if (!joltContent.isEmpty()) {
                for (String num : joltContent.split(",")) {
                    joltages.add(Integer.parseInt(num.trim()));
                }
            }
        }
        return joltages;
    }
    private record Target(int mask, int numLights) {}
}