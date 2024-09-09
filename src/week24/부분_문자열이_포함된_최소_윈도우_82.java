package week24;

import java.util.*;

public class 부분_문자열이_포함된_최소_윈도우_82 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int missing = t.length();
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            right++;
            if (need.containsKey(c) && need.get(c) > 0) {
                missing--;
            }
            need.put(c, need.getOrDefault(c, 0) - 1);

            if (missing == 0) {
                while (left < right && need.get(s.charAt(left)) < 0) {
                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                }

                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }

                need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                missing++;
                left++;
            }
        }
        return s.substring(start, end);
    }
}
