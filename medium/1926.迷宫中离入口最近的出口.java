import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1926 lang=java
 *
 * [1926] 迷宫中离入口最近的出口
 */

// @lc code=start
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                // System.out.println(pos[0] + " " + pos[1]);
                if (isExit(maze, entrance, pos[0], pos[1])) {
                    return count;
                }
                for (int[] dir : dirs) {
                    int nx = dir[0] + pos[0];
                    int ny = dir[1] + pos[1];
                    if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) {
                        continue;
                    }
                    if (maze[nx][ny] == '+') {
                        continue;
                    }
                    queue.offer(new int[] {nx, ny});
                    maze[nx][ny] = '+';
                }
            }
            count++;
        }
        return -1;
    }
    boolean isExit(char[][] maze, int[] entrance, int i, int j) {
        if (i == entrance[0] && j == entrance[1]) return false;
        if (i == 0 || i == maze.length - 1) return true;
        if (j == 0 || j == maze[0].length - 1) return true;
        return false;
    }
}
// @lc code=end

