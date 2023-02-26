import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=764 lang=java
 *
 * [764] 最大加号标志
 */

// @lc code=start
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] g : grid) {
            Arrays.fill(g, 1);
        }
        for (int[] pos : mines) {
            grid[pos[0]][pos[1]] = 0;
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            while (left < n) {
                while (left < n && grid[i][left] == 0) {
                    left++;
                }
                int right = left;
                while (right < n && grid[i][right] != 0) {
                    right++;
                }
                for (int j = left, count = 1; j < right; j++, count++) {
                    // grid[i][j] = Math.min(grid[i][j], count);
                    grid[i][j] = count;
                }
                for (int j = right - 1, count = 1; j >= left; j--, count++) {
                    grid[i][j] = Math.min(grid[i][j], count);
                }
                left = right;
            }
        }
        debug(grid);
        for (int i = 0; i < n; i++) {
            int left = 0;
            while (left < n) {
                while (left < n && grid[left][i] == 0) {
                    left++;
                }
                int right = left;
                while (right < n && grid[right][i] != 0) {
                    right++;
                }
                for (int j = left, count = 1; j < right; j++, count++) {
                    grid[j][i] = Math.min(grid[j][i], count);
                }
                for (int j = right - 1, count = 1; j >= left; j--, count++) {
                    grid[j][i] = Math.min(grid[j][i], count);
                }
                left = right;
            }
        }   
        debug(grid);
        int max = 0;
        for (int[] g : grid) {
            for (int num : g) {
                max = Math.max(num, max);
            }
        }     
        return max;
    }
    void debug(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
// @lc code=end

