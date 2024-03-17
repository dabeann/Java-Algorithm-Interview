package week0;

import java.util.*;

public class 문자열_뒤집기_2 {
    public void solution(String[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        문자열_뒤집기_2 p = new 문자열_뒤집기_2();
        String[] arr = {"r", "a", "c", "e", "c", "a", "a"};
        p.solution(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
