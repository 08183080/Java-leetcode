package src.bit_operation;

public class L136 {
    // 只出现一次的数字
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
