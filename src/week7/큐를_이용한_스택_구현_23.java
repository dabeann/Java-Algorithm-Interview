package week7;

import java.util.*;

public class 큐를_이용한_스택_구현_23 {
    class MyStack {
        Queue<Integer> queue = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            Queue<Integer> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                tempQueue.add(queue.poll());
            }

            queue.offer(x);
            while (!tempQueue.isEmpty()) {
                queue.add(tempQueue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
