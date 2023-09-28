package src.Binary_Search;

public class BT {

    /*
    * 返回有序数组nums中数值<val的所有数据的个数
    * */
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
        int nums[] = {2, 3, 6, 9, 10};
        System.out.println(binarysearch(nums, 1));  // < nums[0]    0
        System.out.println(binarysearch(nums, 6));  // in...        2
        System.out.println(binarysearch(nums, 8));  // in...        3
        System.out.println(binarysearch(nums, 11)); // > nums[n-1]  5

        int nums2[] = {2, 6};
        System.out.println(binarysearch(nums2, 1)); //0
        System.out.println(binarysearch(nums2, 2)); //0
        System.out.println(binarysearch(nums2, 7)); //2
    }

}
