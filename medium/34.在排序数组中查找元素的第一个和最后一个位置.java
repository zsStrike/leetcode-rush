/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {searchLeft(nums, target), searchRight(nums, target)};
    }
    int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        boolean found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
                found = true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return found ? left : -1;
    }
    int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        boolean found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
                found = true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return found ? right : -1;
    }
}
// @lc code=end

