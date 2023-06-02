import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // dp[i] = nums[i] + dp[i - 2], dp[i - 1]
        // dp[i][0] 表示 0 号元素没选择
        // dp[i][1] 表示 0 号元素选择
        // dp[i][0] = nums[i] + dp[i - 2][1], dp[i - 1][1]
        // dp[i][1] = 
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(nums[i] + dp[i - 2][0], dp[i - 1][0]);
            dp[i][1] = Math.max(nums[i] + dp[i - 2][1], dp[i - 1][1]);
        }
        int ans = Math.max(dp[n - 1][0], dp[n - 2][1]);
        return ans;
    }
}
// @lc code=end

