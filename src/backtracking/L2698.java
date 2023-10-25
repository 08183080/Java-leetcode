package src.backtracking;

public class L2698 {
    public static boolean find(int n, String s, int pos, int sum) {
        /*
         * 递归
         *
         * 代码填空...
         * */

        int length = s.length();
        if (pos == length) {
            return sum == n;
        }
        int cur = 0;
        for (int i = pos; i < length; i++) {
            cur = cur * 10 + s.charAt(i);
            if (cur + sum > n) {
                return false;
            }
            if (find(n, s, i + 1, sum + cur)) {
                return true;
            }
        }
        return false;
    }

    public static int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i * i);
            if (find(i, s, 0, 0)) {
                ans += i * i;
            }
        }
        return ans;
    }
}
