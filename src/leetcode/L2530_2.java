package src.leetcode;

import java.util.PriorityQueue;

public class L2530_2 {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue q = new PriorityQueue<Integer>((a,b) -> b-a); // 维护一个降序的优先级队列
        for (int num: nums) {
            q.add(num);
        }

        long ans = 0;
        while (k-- > 0) {
            int max = (int) q.poll();
            ans += max;
//            System.out.println(ans);
            max = (int) Math.ceil((double) max/3);
            q.add(max);
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] nums = {1, 10, 3, 3, 3};int k = 3;
        long ans = maxKelements(nums, k);
        System.out.println(ans);
    }
}
