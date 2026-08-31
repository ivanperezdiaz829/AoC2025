package software.aoc.day11;

import java.util.*;

public class ReactorNetworkReader {
    public ReactorNetwork read(String input) {
        Map<String, List<String>> adjList = new HashMap<>();

        for (String line : input.split("\n")) {
            String trimmedLine = line.trim();
            if (trimmedLine.isEmpty()) { continue; }

            String[] parts = trimmedLine.split(":");
            String device = parts[0].trim();

            List<String> outputs = new ArrayList<>();
            if (parts.length > 1) {
                String[] targets = parts[1].trim().split("\\s+");
                outputs.addAll(Arrays.asList(targets));
            }
            adjList.put(device, outputs);
        }
        return new ReactorNetwork(Map.copyOf(adjList));
    }
}
