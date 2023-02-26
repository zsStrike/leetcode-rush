import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=840 lang=java
 *
 * [840] 矩阵中的幻方
 */

// @lc code=start
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    boolean isMagicSquare(int[][] grid, int x, int y) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.add(grid[x + i][y + j]);
            }
        }
        for (int i = 1; i < 10; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        int sum = -1;
        for (int i = 0; i < 3; i++) {
            int tmp = 0;
            for (int j = 0; j < 3; j++) {
                int xx = i + x, yy = j + y;
                tmp += grid[xx][yy];
            }
            if (sum == -1) {
                sum = tmp;
            } else if (sum != tmp) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            int tmp = 0;
            for (int j = 0; j < 3; j++) {
                int xx = j + x, yy = i + y;
                tmp += grid[xx][yy];
            }
            if (sum != tmp) {
                return false;
            }
        }
        int tmp = 0;
        for (int i = 0; i < 3; i++) {
            int xx = x + i, yy = y + i;
            tmp += grid[xx][yy];
        }
        if (tmp != sum) {
            return false;
        }
        tmp = 0;
        for (int i = 0; i < 3; i++) {
            int xx = x + i, yy = y + 2 - i;
            tmp += grid[xx][yy];
        }
        return tmp == sum;
    }
}
// @lc code=end

