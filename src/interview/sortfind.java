package src.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sortfind {

    public static int findsort(int[] nums, int num) {
        // 有序数组中, 返回和数num最接近的数字下标
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i] - num);
        }

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = i;
            a[i][1] = nums[i];
        }

        Arrays.sort(a,(c,b)->c[1] - b[1]);

        return a[0][0];
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3,4,7,8};
        int ans = findsort(nums, 5);
        System.out.println(ans);
    }

}
