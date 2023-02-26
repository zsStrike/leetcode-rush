import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
class Solution {
    // dp[i] 表示以 i 为结尾的
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        if (max == 1) {
            return n;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                sum += count[i];
            }
        }
        return sum;
        
    }
}
// @lc code=end

