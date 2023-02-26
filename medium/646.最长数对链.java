import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && pairs[j][1] >= pairs[i][0]) {
                j--;
            }
            if (j != -1) {
                dp[i] = 1 + dp[j];
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

