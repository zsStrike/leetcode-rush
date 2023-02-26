/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
class Solution {
    public int surfaceArea(int[][] grid) {
        // 2 + 4 + 2 + 4 + 3 + 4 + 3 + 4 + 4 + 4 = 34
        // 3 + 3 + 3 + 3 + 8 + 8 + 4
        int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    count += 2;
                }
                for (int k = 0; k < 4; k++) {
                    int ii = i + dir[k][0];
                    int jj = j + dir[k][1];
                    if (ii < 0 || jj < 0 || ii >= n || jj >= n) {
                        count += grid[i][j];
                    } else {
                        if (grid[ii][jj] <= grid[i][j]) {
                            count += grid[i][j] - grid[ii][jj];
                        }
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

