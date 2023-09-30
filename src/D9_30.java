package src;


/*
* 全部花开的最早一天?
*
* */

import java.util.Arrays;
import java.util.Map;

public class D9_30 {
    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> growTime[j] - growTime[i]);
        int ans = 0;
        int t = 0;
        for (int id: idx) {
            t += plantTime[id];
            ans = Math.max(ans, t+growTime[id]);
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] plantime = {1,2,3,2};
        int[] growtime = {2,1,2,1};
        int ans = earliestFullBloom(plantime, growtime);
        System.out.println(ans);
    }
}
