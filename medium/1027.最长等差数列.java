/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] nums) {
        // dp[i][j] 表示末尾两项时 nums[i] 和 nums[j] 长度
        // dp[i][i] = 1
        // dp[i][j] = 1 + dp[k][i]; nums[k] = nums[i] - nums[j]
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // System.out.println(i + " " + j);
                int num = nums[j] - nums[i];
                int k;
                for (k = i - 1; k >= 0; k--) {
                    if (nums[k] == nums[i] - num) {
                        // System.out.println(k + " " + i + " " + dp[k][j]);
                        dp[i][j] = Math.max(dp[k][i] + 1, dp[i][j]);
                        break;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
// @lc code=end

