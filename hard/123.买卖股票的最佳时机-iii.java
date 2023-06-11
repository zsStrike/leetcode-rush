import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    // 10^5
    public int maxProfit(int[] prices) {
        // dp[i][j] 表示prices[i..j] 最多两次能卖多少
        int n = prices.length;
        int[] left = new int[n];
        left[0] = 0;
        int leftMin = prices[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }
        int[] right = new int[n];
        right[n - 1] = 0;
        int rightMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }
        int ans = Math.max(left[n - 1], right[0]);
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, left[i - 1] + right[i]);
        }
        return ans;
    }
}
// @lc code=end

