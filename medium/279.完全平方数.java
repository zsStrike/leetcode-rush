/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    // 12 = 4 + 4 + 4
    // 13 = 9 + 4
    // 14 = 9 + 4 + 1
    // 15 = 
    // dp[i] = min(dp[j] + 1) i - j 是完全平方数
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = i;
            int k = (int)Math.sqrt(i);
            for (int j = k; j > 0; j--) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
// @lc code=end

