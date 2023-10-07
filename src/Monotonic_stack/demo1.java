package src.Monotonic_stack;
// 10-7 单调栈

import java.util.Stack;

public class demo1 {
    // 单调栈模板
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            // 绝对慕强
            while (!s.empty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty()?0:i-s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        int[] nums = {100,80,60,70,60,75,85};
        int[] res = nextGreaterElement(nums);
        for (int num : res) {
            System.out.print(num+" ");
        }
    }
}
