import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

// @lc code=start
class Solution {
    // dp[i][j][k] 表示在 i ，j 处 k 次move刚好出界的总次数
    // 返回 dp[i][j][1...k]
    // dp[i][j][k] = sum(dp[i - 1][j][k - 1])
    static final int MOD = 1000_000_007;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        if (maxMove == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i][1] += 1;
            dp[m - 1][i][1] += 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0][1] += 1;
            dp[i][n - 1][1] += 1;
        }
        for (int k = 2; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int xx = i + dir[0];
                        int yy = j + dir[1];
                        if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                            continue;
                        }
                        dp[i][j][k] += dp[xx][yy][k - 1];
                    }
                    dp[i][j][k] %= MOD;
                }
            }
        }
        return (int)(Arrays.stream(dp[startRow][startColumn]).sum() % MOD);
    }
}
// @lc code=end

