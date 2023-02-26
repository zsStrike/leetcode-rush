/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] mx = new int[r][c];
        int idx = 0;
        for (int[] row : mat) {
            for (int num : row) {
                mx[idx/c][idx%c] = num;
                idx++;
            }
        }
        return mx;
    }
}
// @lc code=end

