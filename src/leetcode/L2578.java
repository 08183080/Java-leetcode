package src.leetcode;

public class L2578 {
    // 排序,平分
    public int splitNum(int num) {
        //桶排序
        int[] cnt = new int[10];
        while (num > 0) {
            cnt[num%10]++;
            num = num / 10;
        }

        boolean flag = false;
        int newnum1 = 0;
        int newnum2 = 0;
        for (int i = 0; i < 10; i++) {
            while (cnt[i]-- > 0) {
                if (flag) {
                    newnum1 = newnum1 * 10;
                    newnum1 = newnum1 + i;
                } else {
                    newnum2 = newnum2 * 10;
                    newnum2 = newnum2 + i;
                }
                flag = !flag;
            }
        }
        return newnum1 + newnum2;
    }

    public static void main(String args[]) {
        L2578 q = new L2578();
        int ans = q.splitNum(4325);
        System.out.println(ans);
    }
}
