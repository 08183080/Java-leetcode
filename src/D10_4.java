package src;

import java.util.Arrays;

public class D10_4 {
    //再加一个参数,表示当前至多可以交易j次
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+2][2];

        // 初始化 how?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k + 1; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE/2); // 防止溢出
            }
        }
        for (int j = 1; j <= k + 1; j++) {
            dp[0][j][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k+1; j++) {
                dp[i+1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
                dp[i+1][j][1] = Math.max(dp[i][j][1], dp[i][j-1][0] - prices[i]);
            }
        }
        return dp[n][k+1][0];
    }

    public static void main(String args[]) {
        int k = 2;
        int[] prices = {2,4,1};
        int ans = maxProfit(k, prices);
        System.out.println(ans);
    }

}
