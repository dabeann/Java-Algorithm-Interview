package week25;

import java.util.*;

public class 과반수_엘리먼트_89 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    // 시간 초과 코드
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

    // 엘리먼트 개수 계산
    /*public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        return entryList.get(0).getKey();
    }*/

    // 분할 정복
    /*public int majorityElement(int[] nums) {
        return majorityElement(0, nums.length - 1, nums);
    }

    public int majorityElement(int left, int right, int[] nums) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int a = majorityElement(left, mid, nums);
        int b = majorityElement(mid + 1, right, nums);

        int countA = 0;
        // 구간의 a 개수 계산
        for (int i = left; i <= right; i++) {
            if (nums[i] == a) {
                countA++;
            }
        }
        return countA > (right - left + 1) / 2 ? a : b;
    }*/
}
