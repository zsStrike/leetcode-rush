/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE, sum = 0;
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                count = Math.min(count, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
// @lc code=end

