package src.leetcode;

public class L2562 {
    public long f(int a, int b) {
        int n = 0;
        int origin = b;
        // 统计b的位数...
        while (b > 0) {
            b = b/10;
            n++;
        }
        double ans = a * Math.pow(10, n) + origin;
        return (long)ans;
    }


    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        long ans = 0;
        while (left < right) {
            ans += f(nums[left], nums[right]);
            left++;
            right--;
        }
        if (left == right)  ans += nums[left];
        return ans;
    }

    public static void main(String args[]) {
        L2562 dd = new L2562();
        int[] nums = {7, 52, 2, 4};
        long ans = dd.findTheArrayConcVal(nums);
        System.out.println(ans);
    }
}
