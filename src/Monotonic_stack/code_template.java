package src.Monotonic_stack;

import java.util.Stack;

public class code_template {


    /*
    * 【数组】元素num之后的第一个比num大的元素,若无则返回-1
    * 【输入】数组nums
    * 【输出】结果数组res
    * */
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i>=0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty()?-1:s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        code_template c = new code_template();
        int[] nums = {2,1,2,4,3};
        int[] res = c.nextGreaterElement(nums);
        for (int n:res) {
            System.out.println(n);
        }
    }
}
