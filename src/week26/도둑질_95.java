package week26;

public class 도둑질_95 {
    public int solution(int[] money) {
        if (money.length == 1) {
            return money[0];
        }

        // 첫 번째 집 터는 경우
        // 마지막 집 털 수 없음
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < money.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }

        // 첫 번째 집 털지 않는 경우
        // 마지막 집 털 수 있음
        int[] dp2 = new int[money.length];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp[money.length - 2], dp2[money.length - 1]);
    }
}
