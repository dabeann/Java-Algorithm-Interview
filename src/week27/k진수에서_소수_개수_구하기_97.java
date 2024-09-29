package week27;

import java.util.*;

public class k진수에서_소수_개수_구하기_97 {
    public int solution(int n, int k) {
        int answer = 0;

        String kString = Integer.toString(n, k); // k진수

        String[] kStringArr = kString.split("0");
        for (String s : kStringArr) {
            if (s.equals("") || s.equals("1")) {
                continue;
            }
            if (checkPrime(s)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkPrime(String s) {
        Long sLong = Long.parseLong(s);
        for (int i = 2; i <= Math.sqrt(sLong); i++) {
            if (sLong % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        k진수에서_소수_개수_구하기_97 p = new k진수에서_소수_개수_구하기_97();
        int solution = p.solution(437674, 3);
        System.out.println("solution = " + solution);
    }
}
