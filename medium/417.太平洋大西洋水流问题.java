import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] count = new int[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        count[0][0]--;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] d : dirs) {
                    int xx = d[0] + pos[0];
                    int yy = d[1] + pos[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                        continue;
                    }
                    if ((xx == 0 || yy == 0) && count[xx][yy] == 0) {
                        queue.offer(new int[]{xx, yy});
                        count[xx][yy]--;
                        continue;
                    }
                    if (count[xx][yy] == 0 && heights[xx][yy] >= heights[pos[0]][pos[1]]) {
                        queue.offer(new int[]{xx, yy});
                        count[xx][yy]--;
                    }
                }
            }
        }
        queue.offer(new int[]{m - 1, n - 1});
        count[m - 1][n - 1] += 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] d : dirs) {
                    int xx = d[0] + pos[0];
                    int yy = d[1] + pos[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                        continue;
                    }
                    if ((xx == m - 1 || yy == n - 1) && count[xx][yy] <= 0) {
                        queue.offer(new int[]{xx, yy});
                        count[xx][yy] += 2;
                        continue;
                    }
                    if (count[xx][yy] <= 0 && heights[xx][yy] >= heights[pos[0]][pos[1]]) {
                        queue.offer(new int[]{xx, yy});
                        count[xx][yy] += 2;
                    }
                }
            }
        }       
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;

    }
    
}
// @lc code=end

