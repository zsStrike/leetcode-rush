import java.nio.channels.FileChannel.MapMode;

/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int col = 0; col < n; col++) {
            int i = 0, j = col;
            while (i < m && j < n) {
                if (matrix[i][j] != matrix[0][col]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        for (int row = 0; row < m; row++) {
            int i = row, j = 0;
            while (i < m && j < n) {
                if (matrix[i][j] != matrix[row][0]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}
// @lc code=end

