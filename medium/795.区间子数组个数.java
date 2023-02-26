import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=795 lang=java
 *
 * [795] 区间子数组个数
 */

// @lc code=start
class Solution {
    // dp[i] 表示 num是[i] 结尾
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        long count = 0;
        int[] dp = new int[n];
        if (nums[0] < left || nums[0] > right) {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > right) {
                dp[i] = 0;
            } else if (nums[i] < left) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 1;
                int j = i - 1;
                while (j >= 0 && nums[j] < left) {
                    dp[i] += 1;
                    j--;
                }
                if (j >= 0) dp[i] += dp[j];
            }
        }
        return Arrays.stream(dp).sum();
    }
}
// @lc code=end

