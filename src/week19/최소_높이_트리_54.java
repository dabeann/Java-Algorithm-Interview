package week19;

import java.util.*;

public class 최소_높이_트리_54 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(0);
            return result;
        }

        List<Set<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adjacencyList.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        while (n > 2) {
            int leavesSize = leaves.size();
            n -= leavesSize;

            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                for (int neighbor : adjacencyList.get(leaf)) {
                    adjacencyList.get(neighbor).remove(leaf);
                    if (adjacencyList.get(neighbor).size() == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        while (!leaves.isEmpty()) {
            result.add(leaves.poll());
        }

        return result;
    }
}
