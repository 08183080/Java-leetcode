package src.random;

import java.util.Random;

public class demo {
    public static void main(String args[]) {
        Random r = new Random();
        int cnt = 8;
        while (cnt > 0) {
            System.out.println(r.nextInt(8));// 随机返回[0,8)...
            cnt--;
        }
    }
}
