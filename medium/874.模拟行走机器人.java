import java.util.HashMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    int[][] dirs = {
        {0, 1}, // 北方向
        {1, 0}, // 东方向
        {0, -1}, // 南方向
        {-1, 0}, // 西方向
    };
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer, TreeSet<Integer>> ylines = new HashMap<>(); // x 固定
        HashMap<Integer, TreeSet<Integer>> xlines = new HashMap<>(); // y 固定
        for (int[] obs : obstacles) {
            int xx = obs[0], yy = obs[1];
            ylines.putIfAbsent(xx, new TreeSet<>());
            ylines.get(xx).add(yy);
            xlines.putIfAbsent(yy, new TreeSet<>());
            xlines.get(yy).add(xx);
        }
        int x = 0, y = 0;
        int dir = 0;
        int max = 0;
        for (int cmd : commands) {
            if (cmd > 0) {
                // 判断距离大小
                int xx = x + dirs[dir][0] * cmd;
                int yy = y + dirs[dir][1] * cmd;
                if (dir == 0) {
                    if (ylines.containsKey(xx) && ylines.get(xx).higher(y) != null) {
                        yy = Math.min(yy, ylines.get(xx).higher(y) - 1);
                    }
                } else if (dir == 1) {
                    if (xlines.containsKey(yy) && xlines.get(yy).higher(x) != null) {
                        xx = Math.min(xx, xlines.get(yy).higher(x) - 1);
                    }
                } else if (dir == 2) {
                    if (ylines.containsKey(xx) && ylines.get(xx).lower(y) != null) {
                        yy = Math.max(yy, ylines.get(xx).lower(y) + 1);
                    }
                } else if (dir == 3) {
                    if (xlines.containsKey(yy) && xlines.get(yy).lower(x) != null) {
                        xx = Math.max(xx, xlines.get(yy).lower(x) + 1);
                    }
                }
                x = xx;
                y = yy;
                max = Math.max(max, x * x + y * y);
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else if (cmd == -2) {
                dir = (dir - 1 + 4) % 4;
            }
        }
        return max;
    }
}
// @lc code=end

