/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0xFFFFFFFF;
        while (left >= 0 && left <= right) {
            // System.out.println(left);
            ans = ans & left;
            if (ans == 0) {
                return ans;
            }
            left++;
        }
        return ans;
    }
}
// @lc code=end

