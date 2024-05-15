package week10;

import java.util.*;

public class 상위_k_빈도_엘리먼트_33 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(countMap.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedEntries.get(i).getKey();
        }

        return result;
    }
}
