package src.Monotonic_stack;

import java.util.Stack;

public class L739 {
    // 每日温度
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();   //存储索引
        for (int i = n-1; i >= 0; i--) {
            // 绝对慕强
            while (!s.empty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty()?0:s.peek() - i;
            s.push(i);
        }
        return res;
    }

    public static void main(String args[]) {
        int[] temps = {73,74,75,71,69,72,76,73};
        int[] ans = nextGreaterElement(temps);
        for (int num:ans) {
            System.out.print(num + " ");
        }
    }

}
