package week18;

import java.util.*;

public class 주식을_사고팔기_가장_좋은_시점_II_84 {
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }

        return result;
    }
}
