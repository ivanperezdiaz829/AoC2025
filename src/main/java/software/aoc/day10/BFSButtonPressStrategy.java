package software.aoc.day10;

import java.util.LinkedList;
import java.util.Queue;

public class BFSButtonPressStrategy implements ButtonPressStrategy {
    @Override
    public long findMinimumPresses(Machine machine) {
        int target = machine.targetMask();
        if (target == 0) { return 0; }
        int maxBits = machine.numLights();

        for (Button button : machine.buttons()) {
            int bits = 32 - Integer.numberOfLeadingZeros(button.toggleMask());
            if (bits > maxBits) { maxBits = bits; }
        }
        int maxState = 1 << maxBits;

        boolean[] visited = new boolean[maxState];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        long steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (Button button : machine.buttons()) {
                    int next = current ^ button.toggleMask();
                    if (next == target) { return steps + 1; }
                    if (next < maxState && !visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        throw new IllegalStateException("The objective state could not be obtained");
    }
}
