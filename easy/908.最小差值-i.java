/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        // [1, 3, 6, 15] 4 
        // min [-3, -1, 2, 11]
        // max [5, 7, 10, 19]
        // max 11-19
        // min -3 - 5
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        max -= k;
        min += k;
        return max - min < 0 ? 0 : max - min;
    }
}
// @lc code=end

