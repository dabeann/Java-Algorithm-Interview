package week11;

import java.util.*;

public class 전화번호_문자_조합_36 {
    private static final String[] KEYPAD = {
            "",    "",    "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(result, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
