package src.leetcode;

public class L1155 {
    public static int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        int[][] dp = new int[n+1][target+1];

        for (int j = 1; j <= Math.min(target, k); j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % mod;
                }
            }
        }
        return dp[n][target];
    }


    public static void main(String args[]) {
        int n = 1;
        int k = 6;
        int target = 3;
        int ans =numRollsToTarget(n, k, target);
        System.out.println(ans);
    }
}
