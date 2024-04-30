package week8;

import java.util.*;

public class 원형_데크_디자인_26 {
    class MyCircularDeque {

        private int[] deque;
        private int head = -1;
        private int tail = -1;
        private int size;

        public MyCircularDeque(int k) {
            size = k;
            deque = new int[k];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = 0;
                tail = size - 1;
            }

            head = (head - 1 + size) % size;
            deque[head] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = 0;
                tail = size - 1;
            }

            tail = (tail + 1 + size) % size;
            deque[tail] = value;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1 + size) % size;
            }
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                tail = (tail - 1 + size) % size;
            }
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return deque[head];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return deque[tail];
        }

        public boolean isEmpty() {
            return head == -1 && tail == -1;
        }

        public boolean isFull() {
            return (tail + 1 + size) % size == head;
        }
    }
}
