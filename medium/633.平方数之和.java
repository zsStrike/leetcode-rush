/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= (int)Math.sqrt(c); i++) {
            int a = i * i;
            int left = c - a;
            int b = (int) Math.sqrt(left);
            if (b * b == left) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

