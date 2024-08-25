package week21;

import java.util.*;

public class 팰린드롬_페어_63 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 0; j <= len; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                if (isPalindrome(left)) {
                    Integer idx = wordMap.get(right);
                    if (idx != null && idx != i) {
                        result.add(Arrays.asList(idx, i));
                    }
                }
                if (j != len && isPalindrome(right)) {
                    Integer idx = wordMap.get(left);
                    if (idx != null && idx != i) {
                        result.add(Arrays.asList(i, idx));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
