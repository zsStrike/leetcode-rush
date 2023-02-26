/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        int m = board.length, n = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (board[x][y] == 'E') {
            int count = 0;
            for (int[] dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                    continue;
                }
                if (board[xx][yy] == 'M') {
                    count++;
                }
            }
            if (count == 0) {
                board[x][y] = 'B';
                for (int[] dir : dirs) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                        continue;
                    }
                    if (board[xx][yy] == 'E') {
                        updateBoard(board, new int[]{xx, yy});
                    }
                }
            } else {
                board[x][y] = (char)(count + '0');
            }
        }
        return board;
    }
}
// @lc code=end

