package week2;

import java.util.*;

public class 빗물_트래핑_8 {
    public int trap(int[] height) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                answer += distance * bounded_height;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        빗물_트래핑_8 p = new 빗물_트래핑_8();
        int[] height = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(p.trap(height));
    }
}
