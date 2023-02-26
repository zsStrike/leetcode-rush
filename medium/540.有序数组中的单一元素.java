/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == nums.length - 1) {
                if (nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                } else {
                    right = mid - 2;
                }
            } else if (mid == 0) {
                if (nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                } else {
                    left = mid + 2;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                int leftCount = mid - 1 - left;
                if (leftCount % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                int leftCount = mid - left;
                if (leftCount % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }
}
// @lc code=end

