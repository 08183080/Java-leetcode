package src.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class L1726 {

    public static int f(int a, int b, int c, int d) {
        int ans = 0;
        if ((a*b==c*d) || (a*c == b*d) || (a*d == b*c)) ans+=8;
        return ans;
    }

    // 10-19 1726.同积元组
    // 超时了又...
    public static int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int ans = 0;
        if (n < 4)  return 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int m = k+1;m < n; m++) {
                        if (f(nums[i], nums[j], nums[k], nums[m]) > 0) {
                            ans +=8;
                        }
                    }
                }
            }
        }
        return ans;
    }

    /*
    *  实现比完美更重要，写代码更是要杜绝完美主义，先能用先能跑起来再说其他...
    * GGGG....
    * */
    public static int tupleSameProduct2(int[] nums) {
        // 排序 + 双指针？
        Arrays.sort(nums);  // 升序数组
        int n = nums.length;
        if ( n < 4) return 0;
        int a = 0, b = n - 1;
        int c = a+1, d = b - 1;
        int ans = 0;
        while ( a < b) {
            if (a*b == c*d){
                ans+=8;
            }else if (a*b < c*d) {
                c++;
            } else if (a*b > c*d) {
                d--;
            }
        }
        return ans;
    }


    // 两数之和
    // 可以从 4层loop -> 2层loop+hash
    public static int tupleSameProduct3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int v = nums[i]*nums[j];
                map.put(v, map.getOrDefault(v, 0) + 1);
                ans += (map.getOrDefault(v, 0) - 1)*8;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,4,5,10};
        int ans = tupleSameProduct(nums);
        System.out.println(ans);
    }
}
