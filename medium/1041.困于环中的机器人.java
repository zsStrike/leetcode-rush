/*
 * @lc app=leetcode.cn id=1041 lang=java
 *
 * [1041] 困于环中的机器人
 */

// @lc code=start
class Solution {
    static int[][] dirs = {
        {0, 1}, {-1, 0}, {0, -1}, {1, 0}
    };
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int dir = 0;
        for (int i = 0; i < 2; i++) {
            instructions += instructions;
        }
        // left dir + 1, right dir - 1
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += dirs[dir][0];
                y += dirs[dir][1];
            } else if (c == 'L') {
                dir = dir == 3 ? 0 : dir + 1;
            } else if (c == 'R') {
                dir = dir == 0 ? 3 : dir - 1;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }
}
// @lc code=end

