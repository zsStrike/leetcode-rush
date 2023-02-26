/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    // 1 1 1 1 1 1 1 1
    // 1 1 1 1 1 1 1 0
    // 1 1 1 1 1 1 1 0
    // 1 1 1 1 1 0 0 0
    // 0 1 1 1 1 0 0 0
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] rows = new int[m][n];
        int[][] cols = new int[m][n];
        // rows
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (j == n - 1) {
                    rows[i][j] = matrix[i][j] - '0';
                } else {
                    rows[i][j] = matrix[i][j] == '1' ? 1 + rows[i][j + 1] : 0;
                }
            }
        }
        // cols
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1) {
                    cols[i][j] = matrix[i][j] - '0';
                } else {
                    cols[i][j] = matrix[i][j] == '1' ? 1 + cols[i + 1][j] : 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int min = Math.min(rows[i][j], cols[i][j]);
                System.out.println(min + " " + i + " " + j + " " + max);
                while (min > 0) {
                    int k;
                    for (k = 0; k < min; k++) {
                        if (rows[i + k][j] < min) {
                            min--;
                            break;
                        }
                        if (cols[i][j + k] < min) {
                            min--;
                            break;
                        }
                    }
                    if (k != min) {
                        continue;
                    }
                    max = Math.max(max, min * min);
                    break;
                }
            }
        }
        return max;
    }
}
// @lc code=end

