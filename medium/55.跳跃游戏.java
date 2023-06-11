/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // if (nums.length == 0) return true;
        int cur = 0, n = nums.length;
        int end = cur, nextEnd = cur;
        while (end < n - 1) {
            while (cur <= end) {
                nextEnd = Math.max(nextEnd, cur + nums[cur]);
                cur++;
            }
            if (end == nextEnd) return false;
            end = nextEnd;
        }
        return true;
    }
}
// @lc code=end

