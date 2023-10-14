package src.leetcode;

import java.util.TreeSet;

public class L136 {
    // 可以用 异或 运算
    public int singleNumber(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i]))  set.remove(nums[i]);
            else set.add(nums[i]);
        }
        Integer ans = set.first();     // O(logn)
        return ans;
    }

    /*
    * 空间复杂度:
    * 时间复杂度：
    * */

    public static void main(String args[]) {
        int[] nums = {2,2,1};
        L136 d = new L136();
        int ans = d.singleNumber(nums);
        System.out.println(ans);
    }
}
