/*
 * @lc app=leetcode.cn id=926 lang=java
 *
 * [926] 将字符串翻转到单调递增
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp0 = new int[n];
        dp0[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            dp0[i] = dp0[i - 1];
            if (s.charAt(i) == '1') {
                dp0[i] += 1;
            }
        }
        int[] dp1 = new int[n];
        dp1[n - 1] = s.charAt(n - 1) == '1' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            dp1[i] = dp1[i + 1];
            if (s.charAt(i) == '0') {
                dp1[i] += 1;
            }
        }
        int min = Math.min(dp1[0], dp0[n - 1]);
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp0[i - 1] + dp1[i]);
        }
        return min;
    }
}
// @lc code=end

