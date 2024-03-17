package week1;

public class 가장_긴_팰린드롬_부분_문자열_6 {
    public String solution(String s) {
        String result = "";

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String s1 = s.substring(i, j);
                StringBuilder str = new StringBuilder(s.substring(i, j)).reverse();

                if (s1.equals(str.toString()) && str.length() > result.length()) {
                    result = str.toString();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "dcbabcdd";

        가장_긴_팰린드롬_부분_문자열_6 p = new 가장_긴_팰린드롬_부분_문자열_6();

        System.out.println(p.solution(s));
    }
}
