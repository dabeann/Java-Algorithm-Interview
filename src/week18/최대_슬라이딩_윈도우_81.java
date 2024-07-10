package week18;

import java.util.*;

public class 최대_슬라이딩_윈도우_81 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);

            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
