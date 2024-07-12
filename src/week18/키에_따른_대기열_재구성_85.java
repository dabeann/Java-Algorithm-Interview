package week18;

import java.util.*;

public class 키에_따른_대기열_재구성_85 {
    public int[][] reconstructQueue(int[][] people) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]
        );

        pq.addAll(Arrays.asList(people));

        List<int[]> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }
}
