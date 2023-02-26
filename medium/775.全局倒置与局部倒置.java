/*
 * @lc app=leetcode.cn id=775 lang=java
 *
 * [775] 全局倒置与局部倒置
 */

// @lc code=start
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        return isIdealPermutation(nums, 0);
    }
    boolean isIdealPermutation(int[] nums, int start) {
        int n = nums.length;
        if (start == n) {
            return true;
        }
        if (nums[start] == start) {
            return isIdealPermutation(nums, start + 1);
        }
        if (nums[start] == start + 1) {
            if (start + 1 == n) return true;
            if (nums[start + 1] == start) return isIdealPermutation(nums, start + 2);
            return false;
        }
        return false;
    }
}
// @lc code=end

