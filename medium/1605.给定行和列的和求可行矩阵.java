import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1605 lang=java
 *
 * [1605] 给定行和列的和求可行矩阵
 */

// @lc code=start
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length, c = colSum.length;
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            int tmp = rowSum[i];
            for (int j = 0; j < c; j++) {
                if (colSum[j] > tmp) {
                    ans[i][j] = tmp;
                    colSum[j] -= tmp;
                    tmp = 0;
                } else {
                    ans[i][j] = colSum[j];
                    tmp -= colSum[j];
                    colSum[j] = 0;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

