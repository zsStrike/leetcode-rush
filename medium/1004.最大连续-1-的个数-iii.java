/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    // 10^5 , O(n^2) 不行，
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] ^= 1;
        }
        int min = 0, max = nums.length;
        while (min <= max) {
            // System.out.println(min + " " + max);
            int mid = (min + max) / 2;
            if (check(nums, k, mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min - 1;
    }
    boolean check(int[] nums, int k, int mid) {
        // 找到长度至少为mid的子数组，使其和小于k
        // sum - max <= k
        int sum = 0;
        for (int i = 0; i < mid; i++) {
            sum += nums[i];
        }
        if (sum <= k) return true;
        int n = nums.length;
        int preSum = 0, max = 0;
        for (int i = mid; i < n; i++) {
            sum += nums[i];
            preSum += nums[i - mid];
            max = Math.max(max, preSum);
            if (sum - max <= k) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

