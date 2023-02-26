/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] position) {
        int len = position.length;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < len; i++) {
            if (position[i] % 2 == 0) {
                count2++;
            } else {
                count1++;
            }
        }
        return Math.min(count1, count2);
    }
}
// @lc code=end

