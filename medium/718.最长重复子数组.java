/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j] 表示为以 nums1[i] 和 nums2[j] 结尾的长度
        // init： dp[0][j] 相同为1 dp[i][0] 相同为1
        // dp[i][j] = dp[i-1][j-1] + 1 if nums[i] == nums[j] else 0
        // return max(dp)
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            dp[i][0] = nums1[i] == nums2[0] ? 1 : 0;
        }
        for (int j = 0; j < n2; j++) {
            dp[0][j] = nums1[0] == nums2[j] ? 1 : 0;
        }
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                dp[i][j] = nums1[i] == nums2[j] ? 1 + dp[i - 1][j - 1] : 0;
            }
        }
        int max = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
// @lc code=end

