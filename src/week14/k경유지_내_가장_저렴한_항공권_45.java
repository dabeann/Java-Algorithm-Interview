package week14;

import java.util.*;

public class k경유지_내_가장_저렴한_항공권_45 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, k + 1});

        int[][] minCost = new int[n][k + 2];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCost[src][k + 1] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int city = current[1];
            int stops = current[2];

            if (city == dst) {
                return cost;
            }

            if (stops > 0) {
                List<int[]> neighbors = graph.getOrDefault(city, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    int nextCity = neighbor[0];
                    int nextCost = neighbor[1];

                    int newCost = cost + nextCost;
                    if (newCost < minCost[nextCity][stops - 1]) {
                        minCost[nextCity][stops - 1] = newCost;
                        pq.offer(new int[]{newCost, nextCity, stops - 1});
                    }
                }
            }
        }
        return -1;
    }
}
