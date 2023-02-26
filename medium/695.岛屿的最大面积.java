import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (grid[i][j] == 1) {
                    LinkedList<int[]> list = new LinkedList<>();
                    list.add(new int[]{i, j});
                    while (!list.isEmpty()) {
                        count++;
                        int[] pos = list.removeFirst();
                        grid[pos[0]][pos[1]] = 0;
                        for (int[] dir : dirs) {
                            int x = pos[0] + dir[0];
                            int y = pos[1] + dir[1];
                            if (x < 0 || y < 0 || x >= m || y >= n) {
                                continue;
                            }
                            if (grid[x][y] == 1 && !set.contains(x + " " + y)) {
                                list.add(new int[] {x, y});
                                set.add(x + " " + y);
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}
// @lc code=end

