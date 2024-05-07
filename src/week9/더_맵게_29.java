package week9;

import java.util.*;

public class 더_맵게_29 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int s : scoville) {
            priorityQueue.add(s);
        }

        int answer = 0;
        while (!priorityQueue.isEmpty()) {
            int s1 = priorityQueue.poll();
            if (s1 >= K) {
                break;
            }
            if (priorityQueue.isEmpty()) {
                return -1;
            }
            int s2 = priorityQueue.poll();
            priorityQueue.add(s1 + s2 * 2);
            answer++;
        }
        return answer;
    }
}
