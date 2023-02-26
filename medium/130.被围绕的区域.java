/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        int dir = 0;
        int x = 0, y = 0;
        int m = board.length, n = board[0].length;
        if (m == 1 || n == 1) {
            return;
        }
        do {
            // System.out.println("::::" + x + " " + y);
            if (board[x][y] == 'O') {
                // System.out.println("==========");
                dfs(board, x, y);
            }
            int xx = x + dirs[dir][0];
            int yy = y + dirs[dir][1];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                dir++;
                xx = x + dirs[dir][0];
                yy = y + dirs[dir][1];
            } 
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                dir++;
                xx = x + dirs[dir][0];
                yy = y + dirs[dir][1];
            }  
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                dir++;
                xx = x + dirs[dir][0];
                yy = y + dirs[dir][1];
            }          
            x = xx;
            y = yy;
            if (x == 0 && y == 0) {
                break;
            }
        } while (true);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    void dfs(char[][] grid, int x, int y) {
        // System.out.println(x + " " + y);
        grid[x][y] = 'P';
        int m = grid.length, n = grid[0].length;
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                continue;
            }
            if (grid[xx][yy] == 'O') {
                dfs(grid, xx, yy);
            }
        }
    }
}
// @lc code=end

