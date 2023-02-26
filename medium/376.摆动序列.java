/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        if (nums.length == 2) {
            if (nums[1] == nums[0]) {
                return 1;
            }
            return 2;
        }
        int i = 1;
        while (i < nums.length && nums[i] - nums[i - 1] == 0) {
            i++;
        }
        if (i == nums.length) {
            return 1;
        }
        int cur = nums[i] - nums[i - 1];
        int count = 2;
        for (; i < nums.length; i++) {
            int tmp = nums[i] - nums[i - 1];
            if (tmp == 0) {
                continue;
            }
            if (cur * tmp < 0) {
                cur = tmp;
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

