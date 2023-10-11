package src.leetcode;

public class L2731 {
    // 有问题。。。
    public int sumDistance(int[] nums, String s, int d) {
        char[] chars = s.toCharArray();
        int n = nums.length;
        int cnt = d;
        double ans = 0;
        while (cnt-- > 0) {
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'L') {
                    nums[i]--;
                } else if (chars[i] == 'R') {
                    nums[i]++;
                }
                if ((i <= n-2) && (nums[i] == nums[i+1])) {
                    char c = chars[i];
                    chars[i] = chars[i+1];
                    chars[i+1] = c;
                }
            }
        }

        for (int i = 0;i < n; i++) {
            for (int j = i+1;j < n; j++ ) {
                ans += Math.abs(nums[i] - nums[j]);
            }
        }
        ans = ans%(10e9 + 7);
        int res = (int)ans;
        return res;
    }


    public static void main(String args[]) {
        L2731 dd = new L2731();
        int[] nums = {-2,0,2};
        String s = "RLL";
        int d = 3;
        int ans = dd.sumDistance(nums, s, d);
        System.out.println(ans);
    }
}
