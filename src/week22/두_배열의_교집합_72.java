package week22;

import java.util.*;

public class 두_배열의_교집합_72 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();

        for (int n : nums1) {
            for (int n2 : nums2) {
                if (n == n2) {
                    result.add(n);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
