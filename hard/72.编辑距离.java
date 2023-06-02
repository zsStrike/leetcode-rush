/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 表示 word1[..i] 和 word2[..j] 的编辑距离
        // word1[i] == word2[j] dp[i][j] = dp[i - 1][j - 1]
        // word1[i] != word2[j] dp[i][j] = 1 + dp[i - 1][j] // 删除
        //                      dp[i][j] = 1 + dp[i - 1][j - 1] // 替换
        //                      dp[i][j] = 1 + dp[i][j - 1] // 添加
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int m = cs1.length, n = cs2.length;
        if (m == 0 || n == 0) return m + n;
        int[][] dp = new int[m][n];
        dp[0][0] = cs1[0] == cs2[0] ? 0 : 1;
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1 + dp[0][j - 1];
            if (cs1[0] == cs2[j]) {
                dp[0][j] = Math.min(dp[0][j], j);
            }
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1 + dp[i - 1][0];
            if (cs1[i] == cs2[0]) {
                dp[i][0] = Math.min(dp[i][0], i);
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = 1 + dp[i - 1][j];
                if (cs1[i] == cs2[j]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

