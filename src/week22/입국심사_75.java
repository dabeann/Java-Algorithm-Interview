package week22;

import java.util.*;

public class 입국심사_75 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long mid = right;

        while (left <= right) {
            long calcN = 0;
            for (long time : times) {
                calcN += (mid / time);
            }
            if (calcN >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }

        return answer;
    }
}
