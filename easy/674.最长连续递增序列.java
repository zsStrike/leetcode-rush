/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        int ans = 1;
        while (left < len) {
            right = left + 1;
            while (right < len && nums[right] > nums[right - 1]) {
                right++;
            }
            ans = Math.max(ans, right - left);
            left = right;
        }
        return ans;
    }
}
// @lc code=end

