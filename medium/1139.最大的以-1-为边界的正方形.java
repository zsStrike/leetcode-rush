/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] row = new int[m][n];
        int[][] col = new int[m][n];
        for (int i = 0; i < m; i++) {
            row[i][n - 1] = grid[i][n - 1];
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                row[i][j] = grid[i][j] == 0 ? 0 : row[i][j + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            col[m - 1][i] = grid[m - 1][i];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                col[i][j] = grid[i][j] == 0 ? 0 : col[i + 1][j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int ni = i + col[i][j] - 1;
                int nj = j + row[i][j] - 1;
                int tmp = 1;
                for (int p = ni; p >= i; p--) {
                    for (int q = nj; q >= j; q--) {
                        if (p - i != q - j) {
                            continue;
                        }
                        if (j + row[p][j] > q && i + col[i][q] > p) {
                            tmp = Math.max(tmp, (p - i + 1) * (q - j + 1));
                        }
                    }
                }
                max = Math.max(max, tmp);
            }
        }
        return max;
    }
}
// @lc code=end

