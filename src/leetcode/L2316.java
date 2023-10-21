package src.leetcode;

/**
 *  2023/10/21
 *  2316. 统计无向图中无法互相到达点对数
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L2316 {
    public static void countPairs(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int key = edges[i][0];
            List<Integer> value = map.getOrDefault(key, new ArrayList<>());
            value.add(edges[i][1]);
            map.put(key, value);
            System.out.println(map);
        }
        /*
        *   {0=[1]}
            {0=[1, 2]}
            {0=[1, 2], 1=[2]}
        * */
        //[0,2] and [2,4] -> [0,4]

    }

    public static void main(String args[]) {
        int[][] edges = {{0,1},{0,2},{1,2}};
        int n = 3;
        countPairs(n, edges);
    }
}
