/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int first = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int second = nums[0] * nums[1] * nums[2];
        int third = nums[0] * nums[1] * nums[len - 1];
        return Math.max(Math.max(first, second), third);
    }
}
// @lc code=end

