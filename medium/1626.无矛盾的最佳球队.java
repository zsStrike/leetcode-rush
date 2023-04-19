import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1626 lang=java
 *
 * [1626] 无矛盾的最佳球队
 */

// @lc code=start
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = ages[i];
            items[i][1] = scores[i];
        }
        Arrays.sort(items, (a, b) -> { return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]; });
        // System.out.println(Arrays.deepToString(items));
        int[] dp = new int[n];
        // 定义 dp[i] 表示选择 i 时，最大值
        dp[n - 1] = items[n - 1][1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = items[i][1];
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (items[i][1] <= items[j][1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

