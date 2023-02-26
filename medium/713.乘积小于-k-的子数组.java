/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于 K 的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int pd = 1;
            for (int j = i; j < len; j++) {
                pd *= nums[j];
                if (pd < k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

