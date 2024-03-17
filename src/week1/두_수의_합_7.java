package week1;

import java.util.*;

public class 두_수의_합_7 {
    public int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];

            if (map.containsKey(com)) {
                return new int[]{map.get(com), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 8;

        두_수의_합_7 p = new 두_수의_합_7();

        int[] result = p.solution(nums, target);

        System.out.println(result[0] + " " + result[1]);
    }
}
