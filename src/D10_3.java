package src;

public class D10_3 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        /*
         * dp[n][2][2], 【维度1】总共有n天, 【维度2】总共有2笔交易, 【维度3】在一天结束之后总共有两种交易状态
         * dp[i][0][0] = max(dp[i-1][0][0], dp[i-1][0][1] + prices[i])
         * dp[i][0][1] = max(dp[i-1][0][1], dp[i-1][0][0] - prices[i])
         * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
         * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][1][0] - prices[i])
         * return max(dp[n-1][1][0], dp[n-1][1][1]) -> dp[n-1][1][0]
         * 但是有点问题
         * */
        int[][][] dp = new int[n][2][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][0][1] + prices[i]);
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][1][0] - prices[i]);
        }
        return dp[n-1][1][0];
    }

    public static void main(String args[]) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }

}
