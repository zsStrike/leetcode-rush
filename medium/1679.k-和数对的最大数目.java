import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1679 lang=java
 *
 * [1679] K 和数对的最大数目
 */

// @lc code=start
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] > k) {
                right--;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                count++;
                left++;
                right--;
            }
        }
        return count;
    }
}
// @lc code=end

