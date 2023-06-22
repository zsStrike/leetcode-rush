/*
 * @lc app=leetcode.cn id=2352 lang=java
 *
 * [2352] 相等行列对
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (equal(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    boolean equal(int[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

