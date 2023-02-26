/*
 * @lc app=leetcode.cn id=1031 lang=java
 *
 * [1031] 两个非重叠子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int max = 0;
        for (int i = 0; i < n - firstLen; i++) {
            int sum1 = i == 0 ? sums[firstLen - 1] : sums[i + firstLen - 1] - sums[i - 1];
            for (int j = i + firstLen; j < n - secondLen + 1; j++) {
                int sum2 = sums[j + secondLen - 1] - sums[j - 1];
                max = Math.max(max, sum1 + sum2);
            }
        }
        for (int i = 0; i < n - secondLen; i++) {
            int sum1 = i == 0 ? sums[secondLen - 1] : sums[secondLen - 1 + i] - sums[i - 1];
            for (int j = i + secondLen; j < n - firstLen + 1; j++) {
                int sum2 = sums[j + firstLen - 1] - sums[j - 1];
                max = Math.max(max, sum1 + sum2);
            }
        }
        return max;
    }
}
// @lc code=end

