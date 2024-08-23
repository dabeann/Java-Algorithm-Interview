package week21;

import java.util.*;

public class 이중_우선순위_큐_61 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        List<Integer> list = new ArrayList<>();
        for (String str : operations) {
            String[] a = str.split(" ");
            if (a[0].equals("I")) {
                list.add(Integer.parseInt(a[1]));
                Collections.sort(list);
            } else if (a[0].equals("D") && list.size() > 0) {
                if (a[1].equals("1")) { // 최댓값 삭제
                    list.remove(list.size() - 1);
                } else if (a[1].equals("-1")){ // 최솟값 삭제
                    list.remove(0);
                }
            }
        }
        if (list.size() > 0) {
            answer[1] = list.get(0);
            answer[0] = list.get(list.size() - 1);
        }

        return answer;
    }
}
