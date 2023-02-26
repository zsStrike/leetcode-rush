/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        return getXYArea(grid) + getXZArea(grid) + getYZArea(grid);
    }
    int getXYArea(int[][] grid) {
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
    int getXZArea(int[][] grid) {
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
            sum += max;
        }
        return sum;
    }

    int getYZArea(int[][] grid) {
        int n = grid.length;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, grid[i][j]);
            }
            sum += max;
        }
        return sum;
    }    
}
// @lc code=end

