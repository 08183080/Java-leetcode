package src.dp;

public class gupiao {
    // leetcode 309
    // 股票问题,经典dp...
    //【同类型的题目】122, 309
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[1][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i+2][0] = Math.max(dp[i+1][0], dp[i+1][1] + prices[i]);
            dp[i+2][1] = Math.max(dp[i+1][1], dp[i][0] - prices[i]);
        }
        return dp[n+1][0];
    }
    public static void main(String args[]) {
        int[] prices = {1,2,3,0,2};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }
}
