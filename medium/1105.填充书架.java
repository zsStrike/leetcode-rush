/*
 * @lc app=leetcode.cn id=1105 lang=java
 *
 * [1105] 填充书架
 */

// @lc code=start
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len];
        dp[0] = books[0][1];
        for (int i = 1; i < len; i++) {
            int width = 0;
            int max = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                max = Math.max(books[j][1], max);
                width += books[j][0];
                if (width > shelfWidth) {
                    break;
                }
                if (j - 1 >= 0) {
                    dp[i] = Math.min(dp[i], max + dp[j - 1]);
                } else {
                    dp[i] = Math.min(dp[i], max);
                }
            }
        }
        return dp[len - 1];
    }
}
// @lc code=end

