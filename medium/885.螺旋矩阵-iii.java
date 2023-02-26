import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=885 lang=java
 *
 * [885] 螺旋矩阵 III
 */

// @lc code=start
class Solution {
    int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int dir = 0;
        int x = rStart, y = cStart;
        int[][] ans = new int[rows * cols][2];
        ans[0][0] = x;
        ans[0][1] = y;
        int idx = 1;
        int step = 0;
        while (idx < rows * cols) {
            if (dir == 0 || dir == 2) {
                step += 1;
            }
            for (int i = 1; i <= step; i++) {
                x += dirs[dir][0];
                y += dirs[dir][1];
                if (x < 0 || y < 0 || x >= rows || y >= cols) {
                    continue;
                }
                ans[idx][0] = x;
                ans[idx][1] = y;
                idx++;
            }
            dir = (dir + 1) % 4;
        }
        return ans;
    }
}
// @lc code=end

