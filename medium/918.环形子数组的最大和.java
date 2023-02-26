import java.util.Arrays;

import javax.swing.ToolTipManager;

/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //[1 -2 3 -4 6 1 -2 3 -4 6 1 -2 3 -4 6]
        // [5 -3 5 5 -3 5]
        int n = nums.length;
        int total = nums[0];
        int minDp = nums[0], min = nums[0];
        int maxDp = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            total += nums[i];
            maxDp = Math.max(maxDp + nums[i], nums[i]);
            max = Math.max(max, maxDp);
            minDp = Math.min(minDp + nums[i], nums[i]);
            min = Math.min(min, minDp);
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
// @lc code=end

