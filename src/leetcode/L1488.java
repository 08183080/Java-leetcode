package src.leetcode;

import java.util.*;

public class L1488 {
    // 随机删除法, 通过测试用例 71/82...
    // [1,2,0,2,3,0,1]
    // 删除需要策略,贪心...
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        TreeSet<Integer> set = new TreeSet<>(); // 保存rains[i]==0的下标
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                if (map.containsKey(rains[i])) {
                    // rains[i]>0, 第二次出现了。。。
                    // 1.寻找0出现的位置, 赋予其值rains[i]
                    // 2.删除
                    Integer it = set.ceiling(map.get(rains[i]));// 在第一次出现rains[i]的下标之后寻找满足要求的下标
                    if (it == null) {
                        return new int[]{};
                    } // 没找到下标
                    // 找到下标了.
                    ans[it] = rains[i]; // 该处为0的下标重新赋值
                    set.remove(it); // 下标集合--
                    ans[i] = -1;    // 此处为-1
                    map.put(rains[i], i);   //更新map中的下标
                } else {
                    map.put(rains[i], i);
                    ans[i] = -1;
                }
            }

        }
        return ans;
    }

    public static void main(String args[]) {
        int[] rains = {1,0,2,0,3,0,2,0,0,0,1,2,3};
        L1488 dd = new L1488();
        int[] ans = dd.avoidFlood(rains);
        for (int e: ans) {
            System.out.println(e);
        }
    }

}
