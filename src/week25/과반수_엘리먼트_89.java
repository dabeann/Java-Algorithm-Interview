package week25;

import java.util.*;

public class 과반수_엘리먼트_89 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int moreThanLength = nums.length / 2;
        for (int num : nums) {
            if (Collections.frequency(Arrays.stream(nums).boxed().toList(), num) > moreThanLength) {
                return num;
            }
        }
        return -1;
    }*/
}
