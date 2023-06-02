import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, dir = 0;
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != m * n) {
            ans.add(matrix[x][y]);
            matrix[x][y] = 200;
            int nx = x + dirs[dir][0], ny = y + dirs[dir][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                dir = (dir + 1) % 4;
                nx = x + dirs[dir][0];
                ny = y + dirs[dir][1];
            } else if (matrix[nx][ny] == 200) {
                dir = (dir + 1) % 4;
                nx = x + dirs[dir][0];
                ny = y + dirs[dir][1];                
            }
            x = nx;
            y = ny;
        }
        return ans;
    }
}
// @lc code=end

