/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    // sum[i][j] 表示矩阵 0,0 到 i，j的值
    // sum[i][j] = sum[i][j - 1] + sum[i-1][j] + nums[i][j] - sum[i - 1][j - 1]
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + matrix[i][j] - sum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        }
        if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        }
        if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        }
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

