package src;

public class D10_2 {
    // 贪心
    // 走一步,看一步...
    public static int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i-1]);
        }
        return ans;
    }

    // 动态规划

    public static void main(String args[]) {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }
}
