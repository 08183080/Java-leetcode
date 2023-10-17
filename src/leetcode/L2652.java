package src.leetcode;

public class L2652 {
    public static int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((i%3 == 0) || (i%5==0) || (i%7==0)) {
                ans +=i;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int n = 7;
        System.out.println(sumOfMultiples(n));
    }

}
