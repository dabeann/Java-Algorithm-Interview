package week1;

import java.util.*;

public class 그룹_애너그램_5 {
    public List<List<String>> solution(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "ant", "cat"};

        그룹_애너그램_5 p = new 그룹_애너그램_5();
        List<List<String>> list = p.solution(strings);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
