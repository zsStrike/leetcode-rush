/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < len - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        if (left == len - 1 && right == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // if (left >= right) {
        //     left--;
        //     right = left + 1;
        // }
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (min == Integer.MAX_VALUE) {
            return nums.length;
        }
        while (left > 0 && min < nums[left - 1]) {
            left--;
        }
        while (right <= len - 1 && max > nums[right]) {
            right++;
        }
        // System.out.println(left + " " + right);
        return right - left;
    }
}
// @lc code=end

