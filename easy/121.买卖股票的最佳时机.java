/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max  = prices[n - 1];
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            ans = Math.max(ans, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        return ans;
    }
}
// @lc code=end

