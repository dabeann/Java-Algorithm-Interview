package week7;

public class 원형_큐_디자인_25_배열 {
    class MyCircularQueue {

        int[] array;
        int front;
        int rear;
        int size;
        int capacity;

        public MyCircularQueue(int k) {
            array = new int[k];
            front = 0;
            rear = -1;
            size = 0;
            capacity = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            rear = (rear + 1) % capacity;
            array[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return array[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return array[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
