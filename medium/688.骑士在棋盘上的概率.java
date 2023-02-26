/*
 * @lc app=leetcode.cn id=688 lang=java
 *
 * [688] 骑士在棋盘上的概率
 */

// @lc code=start
class Solution {
    // dp[i][j][k] 表示在 i j ，走 k 步依旧在棋盘内的概率
    // dp[i][j][k] = sum(1/8 * dp[i - 1][j - 2][k - 1])
    int[][] dirs = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int l = 1; l <= k; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int xx = i + dir[0];
                        int yy = j + dir[1];
                        if (xx < 0 || yy < 0 || xx >= n || yy >= n) {
                            continue;
                        }
                        dp[i][j][l] += dp[xx][yy][l - 1] * 0.125;
                    }
                }
            }
        }
        return dp[row][column][k];
    }
}
// @lc code=end

