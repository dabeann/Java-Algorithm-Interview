package week8;

import java.util.*;

public class 원점에서_가장_가까운_k개의_점_28 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            pq.offer(point);
        }

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result.toArray(new int[0][0]);
    }
}
