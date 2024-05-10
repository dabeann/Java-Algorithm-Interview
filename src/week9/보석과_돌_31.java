package week9;

import java.util.*;

public class 보석과_돌_31 {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(String.valueOf(stones.charAt(i)))) {
                answer++;
            }
        }
        return answer;
    }
}
