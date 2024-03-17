package week0;

import java.util.*;

public class 유효한_팰린드롬_1 {
    public boolean solution(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        StringBuilder reversed = new StringBuilder(s).reverse();

        return s.equals(reversed.toString());
    }

    public static void main(String[] args) {
        유효한_팰린드롬_1 p = new 유효한_팰린드롬_1();

        String example = "Do geese see God?";

        System.out.println(p.solution(example));
    }
}
