package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L260 {
    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[2];
        int cnt = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                ans[cnt++] = m.getKey();
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,1,3,2,5};
        int[] ans = new int[2];
        ans = singleNumber(nums);
        for (int num: ans) {
            System.out.println(num);
        }
    }

}
