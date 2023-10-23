package src.leetcode;

public class L2678 {
    public static int countSeniors(String[] details) {
        int ans = 0;
        for (String s: details) {
//            System.out.println(s.substring(11,13));
            String ss = s.substring(11,13);
            int age = Integer.parseInt(ss); // String2int
            if (age > 60) ans++;
        }
        return ans;
    }

    public static void main(String args[]) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        int ans = countSeniors(details);
        System.out.println(ans);
    }
}
