package src.leetcode;

public class L2520 {
    public int countDigits(int num) {
        int ans = 0;
        int n = num;
        while (num > 0) {
            int a = num % 10;
            if (n % a == 0) {
                ans++;
            }
            num = num / 10;
        }
        return ans;
    }
}
