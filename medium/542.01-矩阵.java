import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int cur = 0;
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        cur++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int xx = pos[0] + dir[0];
                    int yy = pos[1] + dir[1];
                    if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                        continue;
                    }
                    if (mat[xx][yy] == 1) {
                        queue.offer(new int[]{xx, yy});
                        mat[xx][yy] = -cur;
                    }
                }                
            }
            cur++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -mat[i][j];
            }
        }
        return mat;
    }
}
// @lc code=end

