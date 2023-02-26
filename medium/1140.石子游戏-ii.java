import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1140 lang=java
 *
 * [1140] 石子游戏 II
 */

// @lc code=start
class Solution {
    public int stoneGameII(int[] piles) {
        // dp[i][M] 表示从 i 开始，为 M 时，Alice 最大的次数，求 dp[0][1]
        // dp[i][M] = p[i] + left - dp[i + 1][max(M, 1)]
        //            p[i] + p[i + 1] + left - dp[i + 2][max(M, 2)]
        //            ...
        //            p[i] + .. + p[i + 2m - 1] + left - dp[i + 2m][max(M, 2M)] 
        // dp[i][M] = rightSum[i] - min(dp[i + j][max(M, j)]) 1 <= j <= M
        int n = piles.length;
        int[] rightSum = new int[n];
        rightSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + piles[i];
        }
        int[][] dp = new int[n][101];
        Arrays.fill(dp[n - 1], rightSum[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            for (int m = 1; m <= 100; m++) {
                // dp[i][m];
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= 2 * m; j++) {
                    if (i + j >= n) {
                        min = 0;
                        break;
                    }
                    if (Math.max(m, j) >= 101) {
                        break;
                    }
                    min = Math.min(min, dp[i + j][Math.max(m, j)]);
                }
                dp[i][m] = rightSum[i] - min;
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[0][1];
    }
}
// @lc code=end

