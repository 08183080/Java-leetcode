package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L137 {
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        // 存储在哈希表中
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        // 寻找哈希表中value为1的key
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] nums = {2,2,3,2};
        int ans = singleNumber(nums);
        System.out.println(ans);
    }
}
