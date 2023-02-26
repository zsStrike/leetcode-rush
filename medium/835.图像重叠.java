/*
 * @lc app=leetcode.cn id=835 lang=java
 *
 * [835] 图像重叠
 */

// @lc code=start
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        // 水平位置 2n 垂直位置 2n
        int max = 0;
        for (int i = -n + 1; i <= n - 1; i++) {
            for (int j = -n + 1; j <= n - 1; j++) {
                max = Math.max(max, compare(img1, img2, i, j));
            }
        }
        return max;
    }
    int compare(int[][] img1, int[][] img2, int x, int y) {
        int n = img1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xx = i + x;
            for (int j = 0; j < n; j++) {
                int yy = j + y;
                if (xx < 0 || xx >= n || yy < 0 || yy >= n) {
                    continue;
                }
                if (img1[i][j] == 1 && img2[xx][yy] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

