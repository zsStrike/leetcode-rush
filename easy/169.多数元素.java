/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candicate = -1;
        for (int num : nums) {
            if (num == candicate) {
                count++;
            } else if (count == 0) {
                count++;
                candicate = num;
            } else {
                count--;
            }
        }
        return candicate;
    }
}
// @lc code=end

