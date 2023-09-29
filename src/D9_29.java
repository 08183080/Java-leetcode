package src;

public class D9_29 {
    /*
    * 找到最长连续0串的个数
    * 0串长度为n, 则
    * 在1之间的时候
    * n=1 -> 0
    * n=2 -> 0
    * n=3 -> 1
    * n=4 -> 1
    * n=5 -> 2
    * n是奇数 -> n/2
    * n是偶数 -> (n-1)/2
    * (n-1)/2
    * 把所有的0,1串都取出来...
    *
    *
    * 没有1,纯0串的时候: (n+1)/2
    *
    * */

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int prev = -1;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev == -1) {
                    cnt += (i/2);
                } else {
                    cnt += (i - prev -2)/2;
                }
                prev = i;
            }
        }
        if (prev >= 0 && prev < m) {
            cnt += (m-1-prev)/2;
        }
        if (prev < 0) {
            cnt+=(m+1)/2;
        }
        return cnt >= n;
    }

    public static void main(String args[]) {
        int[] flowerbed = {0,0,0,0};
        int n = 3;
        Boolean ans = canPlaceFlowers(flowerbed, n);
        System.out.println(ans);
    }
}
