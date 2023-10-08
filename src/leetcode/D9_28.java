package src.leetcode;

import java.util.Arrays;

public class D9_28 {

    /*
    * 对于people[i]
    * 所有的start <= people[i]的数目: x
    * 所有的end < people[i]的数目: y
    * people[i]的数目sum sum = x - y
    * */
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = {};
        int[] end = {};
        int m = people.length;
        int n = flowers.length;
        int[] res = new int[m];
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
//            Arrays.sort(start);
//            Arrays.sort(end);
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < m; i++) {
            int x = binarysearch(start, people[i] + 1);
            int y = binarysearch(end, people[i]);
            res[i] = x - y;
        }
        return res;
    }

    // 返回有序数组num中所有<val的数目
    public static int binarysearch(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = (left + right)>>1;
            if (nums[mid] >= val) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String args[]) {

    }
}
