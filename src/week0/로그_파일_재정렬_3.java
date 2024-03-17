package week0;

import java.util.*;

public class 로그_파일_재정렬_3 {
    public String[] solution(String[] s) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : s) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                // 문자가 동일한 경우 식별자 순
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letterList.addAll(digitList);
        return letterList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        로그_파일_재정렬_3 p = new 로그_파일_재정렬_3();

        String[] arr = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"};
        String[] arr2 = p.solution(arr);

        for (String s : arr2) {
            System.out.println(s);
        }
    }
}
