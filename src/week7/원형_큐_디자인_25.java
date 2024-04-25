package week7;

import java.util.*;

public class 원형_큐_디자인_25 {
    class MyCircularQueue {

        Deque<Integer> deque;
        int capacity;

        public MyCircularQueue(int k) {
            deque = new LinkedList<>();
            capacity = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            deque.addLast(value);
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            deque.removeFirst();
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public boolean isFull() {
            return deque.size() == capacity;
        }
    }
}
