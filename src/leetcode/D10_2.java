package src.leetcode;

public class D10_2 {
    // 贪心
    // 走一步,看一步...
    public static int maxProfit(int[] prices) {
//        贪心
//        int ans = 0;
//        int n = prices.length;
//        for (int i = 1; i < n; i++) {
//            ans += Math.max(0, prices[i] - prices[i-1]);
//        }
//        return ans;

//        状态机dp, v1
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i+1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i+1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[n][0];
    }

    // 动态规划
    /*
    * 【股票问题】
    *  dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    *  dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
    *  dp[0][0] = 0
    *  dp[0][1] = -prices[0]
    *  max(dp[i][0], dp[i][1]) = dp[i][0]
    *  return dp[n-1][0]
    * */

    public static void main(String args[]) {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }
}
