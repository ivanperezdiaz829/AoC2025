package software.aoc.day08;

import java.util.ArrayList;
import java.util.List;

public class UnionFinder {
    private final int[] parent;
    private final int[] size;

    public UnionFinder(int totalBoxes) {
        parent = new int[totalBoxes];
        size = new int[totalBoxes];
        for (int i = 0; i < totalBoxes; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) { return false; }

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        return true;
    }

    private int find(int p) {
        int root = p;
        while (root != parent[root]) { root = parent[root]; }

        int current = p;
        while (current != root) {
            int next = parent[current];
            parent[current] = root;
            current = next;
        }
        return root;
    }

    public List<Integer> getComponentSizes() {
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) { sizes.add(size[i]); }
        }
        return sizes;
    }
}
