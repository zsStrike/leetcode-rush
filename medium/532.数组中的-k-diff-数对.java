import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的 k-diff 数对
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int len = nums.length;
        int count = 0;
        while (right < len) {
            if (right <= left) {
                right++;
                continue;
            }
            if (nums[right] - nums[left] > k) {
                left++;
            } else if (nums[right] - nums[left] < k) {
                right++;
            } else {
                count++;
                int next = left;
                while (next < len && nums[next] == nums[left]) {
                    next++;
                }
                left = next;
                right++;
            }
        }
        return count;
    }
}
// @lc code=end

