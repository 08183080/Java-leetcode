package src.leetcode;

public class L2525 {
    /*
            2023-10-20
    * nem == n * 10^m
    * 10e9 == 10 * 10^9 == 10^10
    * 1e9 == 1 * 10^9 == 10^9
    *
    * my notes: https://leetcode.cn/problems/categorize-box-according-to-criteria/solutions/2490553/tiao-jian-xuan-ze-gen-ju-gui-ze-jiang-xi-8pln/
    * */
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean a = false, b = false;
        long p = (long) length * width * height;
        if (length >= 1e4 || width >= 1e4 || height >= 1e4 || p >= 1e9) a = true;//"Bulky"
        if (mass >= 100)   b = true;   //"Heavy"
        if (a && b) return "Both";
        else if (!a && !b)  return "Neither";
        else if (a && !b)   return "Bulky";
        else return "Heavy";
    }

    public static void main(String args[]) {
        int length, width, height, mass;
        length = 3223; width = 1271; height = 2418;mass = 749;
        String ans = categorizeBox(length, width, height, mass);
        System.out.println(ans);
//        System.out.println(10e9);
//        boolean b = (9000000000L >= 10e9);
//        System.out.println(b);
    }
}
