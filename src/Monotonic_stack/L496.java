package src.Monotonic_stack;

import java.util.HashMap;
import java.util.Stack;

public class L496 {
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            // 绝对慕强
            while (!s.empty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty()?-1:s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greater[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
