package week2;

import java.util.*;

public class 배열_파티션1_10 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) answer += nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        배열_파티션1_10 p = new 배열_파티션1_10();
        int[] nums = {1, 3, 4, 2};
        System.out.println(p.arrayPairSum(nums));
    }
}
