package src;
/*
* 9-26 数学推理
* */
public class D9_26 {
    public static int passthePillow(int n, int time) {
        int num = 0;
        int q = time % (2*(n - 1));     // int q = time % 2*(n - 1);则是错误的...
        if (q <= n - 1) {
            num = q +1;
        } else {
            num = 2*n - 1 - q;
        }
        return num;
    }

    public static void main(String args[]) {
        int n = 4, time = 5;
        int ans = passthePillow(n, time);
        System.out.println(ans);
    }

}
