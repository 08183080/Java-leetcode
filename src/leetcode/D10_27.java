package src.leetcode;

import java.util.Arrays;

public class D10_27 {

    public static int cal(int[] arr, int n) {
        int ans = 0;
        int pre = 0;
        for (int a: arr) {
            ans = Math.max(ans, a - pre);
            pre = a;
        }
        ans = Math.max(ans, n - pre);
        return ans;
    }
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long l = (long) cal(horizontalCuts, h) * (long) cal(verticalCuts, w) % 1000000007;
        return (int)l;
    }
}
