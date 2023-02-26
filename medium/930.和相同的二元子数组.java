/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0) {
            return numSubarraysZero(nums);
        }
        int count = 0;
        int n = nums.length;
        int[] leftZeros = new int[n];
        int[] rightZeros = new int[n];
        leftZeros[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == 0) {
                leftZeros[i] = leftZeros[i - 1] + 1;
            } else {
                leftZeros[i] = 0;
            }
        }
        rightZeros[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] == 0) {
                rightZeros[i] = rightZeros[i + 1] + 1;
            } else {
                rightZeros[i] = 0;
            }
        }
        int sum = 0;
        int left = 0;
        while (left < n && nums[left] == 0) {
            left++;
        }
        int right = left;
        while (right < n) {
            sum += nums[right];
            if (sum == goal) {
                break;
            }
            right++;
        }
        while (right < n) {
            count += (leftZeros[left] + 1) * (rightZeros[right] + 1);
            left++;
            while (left < n && nums[left] == 0) {
                left++;
            }
            right++;
            while (right < n && nums[right] == 0) {
                right++;
            }
        }
        return count;
    }
    int numSubarraysZero(int[] nums) {
        int n = nums.length;
        int left = 0;
        int count = 0;
        while (left < n) {
            while (left < n && nums[left] == 1) {
                left++;
            }
            int right = left;
            while (right < n && nums[right] == 0) {
                right++;
            }
            int delta = right - left;
            count += delta + (delta - 1) * delta / 2;
            left = right;
        }
        return count;
    }
}
// @lc code=end

