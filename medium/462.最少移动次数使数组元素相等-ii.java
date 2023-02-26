import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 */

// @lc code=start
class Solution {
    // 22 / 4 = 5.5 6
    // 5 + 4 + 4 + 3
    // 15 / 5 = 3
    // 2 + 3 + 3 + 5 + 3 = 
    // 1 + 1 + 7 + 5 = 14
    public int minMoves2(int[] nums) {
        long sum = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int target = nums[n / 2];
        for (int num : nums) {
            sum += Math.abs(target - num);
        }
        return (int)sum;
    }
}
// @lc code=end

