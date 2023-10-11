package src.hash;

import java.util.*;

public class L2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String s:positive_feedback) {
            hash.put(s, +3);
        }
        for (String s:negative_feedback) {
            hash.put(s, -1);
        }

        int n = student_id.length;
        int s[] = new int[n];
        int A[][] = new int[n][2];      // 二维数组把下标也存储起来，方便自定义排序...
        for (int i = 0; i < n; i++) {
            for (String ss: report[i].split(" ")){
                if (hash.containsKey(ss)) {
                    s[i] += hash.get(ss);
                }
            }
            A[i] = new int[]{student_id[i], s[i]};
        }

//        for (int nn: ans) {
//            System.out.println(nn);
//        }

        // 排序
        /*
        * 我想要把数组进行排序, 然后是按照降序排序的，然后数据相同的时候，返回小的下标
        * Arrays.sort()的lambda排序
        *
        * */
        Arrays.sort(A, (a,b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

        List<Integer> topk = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topk.add(A[i][0]);
        }
        return topk;
    }

    public static void main(String args[]) {
        String[] p = {"smart","brilliant","studious"};
        String[] n = {"not"};
        String[] r = {"this student is studious","the student is smart"};
        int[] s = {1,2};
        int k = 2;

        L2512 dd = new L2512();
        List<Integer> ans = new ArrayList<>();
        ans = dd.topStudents(p, n, r, s, k);
        for (Integer a: ans) {
            System.out.println(a);
        }
    }
}
