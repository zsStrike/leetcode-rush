import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=861 lang=java
 *
 * [861] 翻转矩阵后的得分
 */

// @lc code=start
class Solution {
    // 先行后列，行看首位 列看0个数
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            int zeroCount = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount > m / 2) {
                for (int j = 0; j < m; j++) {
                    grid[j][i] = 1 - grid[j][i];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            String str = "";
            for (int bit : grid[i]) {
                str += bit;
            }
            ans += Integer.parseInt(str, 2);
        }
        return ans;
    }
}
// @lc code=end

