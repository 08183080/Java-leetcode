package src.leetcode;

public class L2530 {
    public static int getMaxIndex(int[] nums) {
        int n = nums.length;
        int max = nums[0], index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static long maxKelements(int[] nums, int k) {
        /*  1.首先获得nums中最大元素的下标
        *   2.然后对于该最大元素进行操作
        * */
        long ans = 0;
        while (k-- > 0) {
            int index = getMaxIndex(nums);
            //System.out.println(nums[index]);
            ans += nums[index];
            nums[index] = (int) Math.ceil((double) nums[index]/3);  // Math.ceil need a double input, and returns a double output...

            //System.out.println(nums[index]);
        }
        return ans;
    }
    // 可以通过32/39个testcase, 但是再往后就超时啦...

    public static void main(String args[]) {
        int[] nums = {1,10,3,3,3};
        int k = 3;
        long ans = maxKelements(nums, k);
        System.out.println(ans);
//        double ans = Math.ceil((double) 10/(double) 3);
//        System.out.println(ans);
    }
}
