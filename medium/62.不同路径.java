import java.math.BigInteger;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {

    static int[][] C = new int[105][105];
    static {
        for (int i = 0; i < 105; i++) {
            C[i][0] = 1;
        }
        for (int i = 1; i < 105; i++) {
            for (int j = 1; j <= i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    public int uniquePaths(int m, int n) {
        // C(m + n - 2, n - 1)
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[m][i] = 1;
        }
        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[1][1];
        // return C[m + n - 2][n - 1];
    }
}
// @lc code=end

