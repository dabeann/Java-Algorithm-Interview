package week16;

import java.util.*;

public class 배열의_k번째_큰_엘리먼트_60 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}
