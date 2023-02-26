/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int left = 0, right = nums.length - 1;
        while (left < len - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        if (left == len - 1 && right == 0) {
            return true;
        }
        if (left != right - 1) {
            return false;
        }
        if (left == 0 || right == len - 1) {
            return true;
        }
        if (nums[left - 1] <= nums[left + 1] || nums[right - 1] <= nums[right + 1]) {
            return true;
        }
        return false;
    }
}
// @lc code=end

