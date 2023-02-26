/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    static int[] nums = new int[38];
    static {
        int len = nums.length;
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i < len; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
    }
    public int tribonacci(int n) {
        return nums[n];
    }
}
// @lc code=end

