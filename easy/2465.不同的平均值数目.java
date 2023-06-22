/*
 * @lc app=leetcode.cn id=2465 lang=java
 *
 * [2465] 不同的平均值数目
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            set.add(nums[left] + nums[right]);
            left++;
            right--;
        }
        return set.size();
    }
}
// @lc code=end

