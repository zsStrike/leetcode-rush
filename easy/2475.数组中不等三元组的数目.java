/*
 * @lc app=leetcode.cn id=2475 lang=java
 *
 * [2475] 数组中不等三元组的数目
 */

// @lc code=start
class Solution {
    public int unequalTriplets(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[k] || nums[j] == nums[k]) {
                        continue;
                    }
                    total++;
                }
            }
        }
        return total;
    }
}
// @lc code=end

