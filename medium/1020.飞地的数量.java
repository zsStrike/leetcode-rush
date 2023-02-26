/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    static int[][] dirs = new int[][] {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    int ans = 0;
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int x = 0, y = 0;
        int didx = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }
        do {
            if (grid[x][y] == 1) {
                dfs(grid, x, y);
            }
            int xx = x + dirs[didx][0];
            int yy = y + dirs[didx][1];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                didx += 1;
                if (didx == 4) {
                    break;
                }
                xx = x + dirs[didx][0];
                yy = y + dirs[didx][1];
            }
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                didx += 1;
                if (didx == 4) {
                    break;
                }
                xx = x + dirs[didx][0];
                yy = y + dirs[didx][1];
            }            
            x = xx;
            y = yy;
        } while (true);
        
        return sum - ans;
    }
    void dfs(int[][] grid, int x, int y) {
        // System.out.println(x + " " + y + " " + ans);
        int m = grid.length;
        int n = grid[0].length;        
        ans++;
        grid[x][y] = 0;
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (xx >= m || xx < 0 || yy < 0 || yy >= n) {
                continue;
            }
            if (grid[xx][yy] == 1) {
                dfs(grid, xx, yy);
            }
        }
    }
}
// @lc code=end

