/*
 * @lc app=leetcode.cn id=789 lang=java
 *
 * [789] 逃脱阻碍者
 */

// @lc code=start
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int cur = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int tmp = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (tmp <= cur) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

