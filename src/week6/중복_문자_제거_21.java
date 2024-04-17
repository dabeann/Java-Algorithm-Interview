package week6;

import java.util.*;

public class 중복_문자_제거_21 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        Set<Character> visited = new HashSet<>();

        for (char ch : s.toCharArray()) {
            count[ch - 'a']--;

            if (visited.contains(ch)) {
                continue;
            }

            while (result.length() > 0 && result.charAt(result.length() - 1) > ch && count[result.charAt(result.length() - 1) - 'a'] > 0) {
                char lastChar = result.charAt(result.length() - 1);
                result.deleteCharAt(result.length() - 1);
                visited.remove(lastChar);
            }

            result.append(ch);
            visited.add(ch);
        }

        return result.toString();
    }
}
