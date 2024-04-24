package week7;

import java.util.*;

public class 스택을_이용한_큐_구현_24 {
    class MyQueue {
        Stack<Integer> stack = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                int item = stack.pop();
                push(x);
                stack.push(item);
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
