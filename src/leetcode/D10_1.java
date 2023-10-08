package src.leetcode;public class D10_1 {
    public int maxProfit(int[] prices) {
        // dp[i] = nums[i] - min(nums[0...i-1])
        // max(dp[0...n-1])
        int n = prices.length;
        int mmax = 0;
        int minn = prices[0];
        for (int i = 1; i < n; i++) {
            minn = Math.min(minn, prices[i-1]);
            mmax = Math.max(mmax, prices[i] - minn);
        }
        return mmax;
    }
}
