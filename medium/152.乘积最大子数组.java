/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        return maxProduct(nums, 0, nums.length - 1);
    }
    private int maxProduct(int[] nums, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        if (start == end) {
            return nums[start];
        }
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] == 0) {
                max = Math.max(maxProduct(nums, start, i - 1), maxProduct(nums, i + 1, end));
                max = Math.max(max, 0);
                return max;
            }
        }
        max = 1;
        for (int i = start; i <= end; i++) {
            max *= nums[i];
        }
        if (max > 0) {
            return max;
        }
        int left = 1, right = 1;
        for (int i = start; i <= end; i++) {
            left *= nums[i];
            if (nums[i] < 0) {
                break;
            }
        }
        for (int i = end; i >= start; i--) {
            right *= nums[i];
            if (nums[i] < 0) {
                break;
            }
        }
        int neg = Math.max(left, right);
        return max / neg;
    }
}
// @lc code=end

