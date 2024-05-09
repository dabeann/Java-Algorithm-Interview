package week9;

import java.util.*;

public class 해시맵_디자인_30 {
    class MyHashMap {
        private int[] map;

        public MyHashMap() {
            this.map = new int[10];
        }

        public void put(int key, int value) {
            if (key >= this.map.length) {
                this.map = Arrays.copyOf(this.map, key + 1);
            }
            this.map[key] = value == 0 ? -1 : value;
        }

        public int get(int key) {
            if (key >= this.map.length || this.map[key] == 0) {
                return -1;
            } else {
                return this.map[key] == -1 ? 0 : this.map[key];
            }
        }

        public void remove(int key) {
            if (key < this.map.length) {
                this.map[key] = 0;
            }
        }
    }
}
