import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1235 lang=java
 *
 * [1235] 规划兼职工作
 */

// @lc code=start
class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 定义 dp[i] 表示 [0 ..i] 结束的最大利润
        // dp[i] = dp[j] + profit[i] or dp[j - 1]
        int n = startTime.length;
        int[][] items = new int[n][3];
        for (int i = 0; i < n; i++) {
            items[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(items, (a, b) -> a[1] - b[1]);
        // System.out.println(Arrays.toString(items));
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = items[0][2];
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && items[j][1] > items[i][0]) {
                j--;
            }
            if (j >= 0) {
                dp[i] = Math.max(dp[i], dp[j] + items[i][2]);
            } else {
                dp[i] = items[i][2];
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
// @lc code=end

