import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=934 lang=java
 *
 * [934] 最短的桥
 */

// @lc code=start
class Solution {
    static int[][] dirs = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int i = 0, j = 0;
        outer:
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    break outer;   
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        invert(i, j, grid, queue);
        grid[i][j] = -1;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int ni = pos[0] + dir[0];
                    int nj = pos[1] + dir[1];
                    if (ni < 0 || nj < 0 || ni >= n || nj >= n) {
                        continue;
                    }
                    if (grid[ni][nj] == 1) {
                        return count;
                    }
                    if (grid[ni][nj] == 0) {
                        queue.offer(new int[] {ni, nj});
                        grid[ni][nj] = -1;
                    }
                }
            }
            count++;
        }
        return n;
    }
    void invert(int i, int j, int[][] grid, Queue<int[]> queue) {
        int n = grid.length;
        grid[i][j] = 2;
        queue.offer(new int[] {i, j});
        for (int[] dir : dirs) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii < 0 || jj < 0 || ii >= n || jj >= n) {
                continue;
            }
            if (grid[ii][jj] == 1) {
                invert(ii, jj, grid, queue);
            }
        }
    }
}
// @lc code=end

