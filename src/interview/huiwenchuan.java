package src.interview;

public class huiwenchuan {
    // 判断字符串是否为回文串
    // 2023-10-12 测开初面
    public boolean judge(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int left = 0, right = n-1;
        while (left < right) {
            if (c[left] != c[right])    return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String args[]) {
        String s= "bab";
        huiwenchuan h = new huiwenchuan();
        if (h.judge(s)) {
            System.out.println("是回文串");
        } else {
            System.out.println("不是回文串");
        }
    }
}
