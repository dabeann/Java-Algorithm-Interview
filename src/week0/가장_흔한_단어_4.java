package week0;

import java.util.*;

public class 가장_흔한_단어_4 {
    public String solution(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ban = new ArrayList<>(Arrays.asList(banned));

        String[] strings = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String s : strings) {
            if (!ban.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = {"hit"};

        가장_흔한_단어_4 p = new 가장_흔한_단어_4();
        System.out.println(p.solution(paragraph, banned));
    }
}
