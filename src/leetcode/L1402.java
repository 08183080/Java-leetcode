package src.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class L1402 {
    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);  // sort
        int n = satisfaction.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int res = 0;
            for (int j = i; j < n; j++) {
                res += satisfaction[j] * (j-i+1);
            }
//            System.out.println(res);
            ans = Math.max(res, ans);
        }
        return ans;
    }

    public static int maxSatisfaction2(int[] satisfaction) {
        // greedy
        Arrays.sort(satisfaction);
        int ans = 0;
        int pre = 0;
        int n = satisfaction.length;
        for (int i = n-1; i >=0; i--) {
            int res = 0;
            if (pre + satisfaction[i] > 0) {
                pre += satisfaction[i];
                ans += pre;
            }else {
                break;
            }
        }
        return ans;
    }


    public static void main(String args[]) {
        int[] s = {-9,-8,-1,0,5};
        int ans = maxSatisfaction2(s);
        System.out.println(ans);
    }
}
