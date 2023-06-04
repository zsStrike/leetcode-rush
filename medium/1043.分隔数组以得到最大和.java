import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] 分隔数组以得到最大和
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            for (int j = i, max = arr[j]; j >= 0 && i - j + 1 <= k; j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], (j == 0 ? 0 : dp[j - 1]) + (i - j + 1) * max);
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

