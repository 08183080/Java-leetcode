package src.leetcode;

public class L2698 {

    public static boolean find(int n, String s, int pos, int sum) {
        /*
        * 递归
        * */

        int length = s.length();
        if (pos == length) {
            return sum == n;
        }
        int cur = 0;
        for (int i = pos; i < length; i++) {
            cur = cur * 10 + (s.charAt(i) - '0');
            if (cur + sum > n)  return false;
            if (find(n, s, i + 1, sum + cur)) {
                return true;
            }
        }
        return false;
    }

    public static int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String s = Integer.toString(square);
            if (find(i, s, 0, 0)) {
                ans += square;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int n = 10;
        int ans = punishmentNumber(n);
        System.out.println(ans);
    }
}
