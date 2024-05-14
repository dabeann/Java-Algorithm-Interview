package week10;

import java.util.*;

public class 중복_문자_없는_가장_긴_부분_문자열_32 {
    public int lengthOfLongestSubstring(String s) {
        int prev = 0;
        int idx = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (idx < s.length()) {
            char cur = s.charAt(idx);

            if (!set.contains(cur)) {
                set.add(cur);
                idx++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(prev));
                prev++;
            }
        }
        return max;
    }
}
