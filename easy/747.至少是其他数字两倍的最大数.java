/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int max1, max2;
        max1 = max2 = -1000;
        int idx = -1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num > max1) {
                max2 = max1;
                max1 = num;
                idx = i;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return max1 >= max2 * 2 ? idx : -1;
    }
}
// @lc code=end

