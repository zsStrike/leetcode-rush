/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
        for (int sum = m + n - 3; sum >= 0; sum--) {
            for (int i = 0; i < m; i++) {
                int j = sum - i;
                if (j < 0 || j >= n) continue;
                if (obstacleGrid[i][j] == 1) continue;
                if (i < m - 1) dp[i][j] += dp[i + 1][j];
                if (j < n - 1) dp[i][j] += dp[i][j + 1];
                // System.out.println(i + " " + j + " " + dp[i][j]);
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

