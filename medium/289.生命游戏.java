/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public static final int[][] dirs = {
        {1, 1}, {1, 0}, {1, -1},
        {0, 1}, {0, -1},
        {-1, 1}, {-1, 0}, {-1, -1}
    };
    public void gameOfLife(int[][] board) {
        // 每个细胞周围 8 个细胞判断
        //   活细胞：2-3 能存活，否则死亡  使用 -1 代替
        //   死细胞：3 能复活 使用 2 代替
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (countAlive(board, i, j) != 2 && countAlive(board, i, j) != 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (countAlive(board, i, j) == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countAlive(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                continue;
            }
            if (board[xx][yy] == 1 || board[xx][yy] == -1) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

