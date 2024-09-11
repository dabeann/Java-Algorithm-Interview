package week24;

import java.util.*;

public class 태스크_스케줄러_86 {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char c : tasks) {
            freqs[c - 'A']++;
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freqs) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int result = 0;
        while (true) {
            int intervals = 0;
            List<Integer> list = new ArrayList<>();

            while (!pq.isEmpty()) {
                int frequency = pq.poll();
                if (intervals < n + 1) {
                    intervals++;
                    result++;
                    if (frequency > 1) {
                        list.add(frequency - 1);
                    }
                } else {
                    list.add(frequency);
                }
            }
            if (list.isEmpty()) {
                break;
            }
            pq.addAll(list);
            result += n + 1 - intervals;
        }
        return result;
    }
}
