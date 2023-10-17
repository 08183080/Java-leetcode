package src.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sortfind {

    public static int findsort(int[] nums, int num) {
        // 有序数组中, 返回和数num最接近的数字下标
        // 哈希表
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

    // 二分查找 -> 升序
    public static int findsort2(int[] nums, int num) {
        int n = nums.length;
        int l = 0, r = n-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] == num) {
                return mid;
            } else if (nums[mid] < num) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }



    public static void main(String args[]) {
        int[] nums = {3,5,7,9};
        int ans = findsort(nums, 1);
        System.out.println(ans);
    }

}
