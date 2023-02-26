import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int m = image.length, n = image[0].length;
        int preColor = image[sr][sc];
        if (preColor == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        image[sr][sc] = color;
        queue.offer(new int[]{sr, sc});
        while (queue.isEmpty() == false) {
            int size = queue.size();
            while (size > 0) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int xx = pos[0] + dir[0];
                    int yy = pos[1] + dir[1];
                    if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                        continue;
                    }
                    if (image[xx][yy] == preColor) {
                        image[xx][yy] = color;
                        queue.offer(new int[]{xx, yy});
                    }
                }
                size--;
            }
        }
        return image;
    }
}
// @lc code=end

