package week24;

import java.util.*;

public class 주유소_87 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int start = 0;
        int fuel = 0;
        for (int i = 0; i < gas.length; i++) {
            if (fuel + gas[i] - cost[i] < 0) {
                start = i + 1;
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }
        return start;
    }
}
