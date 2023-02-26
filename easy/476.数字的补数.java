/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append((num + 1) % 2);
            num >>= 1;
        }
        return Integer.valueOf(sb.reverse().toString(), 2);
    }
}
// @lc code=end

