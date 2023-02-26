import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[n];
        int left = 0;
        while (left < n) {
            int right = left;
            while (right < n && nums[right] == nums[left]) {
                count[right] = right - left + 1;
                right++;
            }
            left = right;
        }
        System.out.println(Arrays.toString(count));
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int j = i - count[i];
            if (j >= 0 && nums[j] + 1 < nums[i]) {
                dp[i] = dp[j] + count[i] * nums[i];
                continue;
            }
            int k = j >= 0 ? j - count[j] : -1;
            int a = k >= 0 ? nums[i] * count[i] + dp[k] : nums[i] * count[i]; // 选择
            int b = j >= 0 ? dp[j] : 0;
            dp[i] = Math.max(a, b);
        }
        return dp[n - 1];
    }
}
// @lc code=end

