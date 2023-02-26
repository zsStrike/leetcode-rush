/*
 * @lc app=leetcode.cn id=813 lang=java
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
class Solution {
    // dp[i][j] 表示以 i 结尾的最多 j 个数组的大小
    // dp[i][j] = max(nums[i] + dp[i - 1][j - 1], )
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        double[] sums = new double[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        double[][] dp = new double[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = sums[i] / (i + 1);
        }
        
        for (int j = 2; j <= k; j++) {
            for (int i = 0; i < n; i++) {
                for (int m = i; m >= 1; m--) {
                    // nums[m..i]
                    double tmp = m == 0 ? sums[i] : sums[i] - sums[m - 1];
                    tmp = tmp / (i - m + 1);
                    dp[i][j] = Math.max(dp[i][j], dp[m - 1][j - 1] + tmp);
                }
            }
        }
        return dp[n - 1][k];
    }
}
// @lc code=end

