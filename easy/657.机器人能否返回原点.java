/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int uc = 0, dc = 0, lc = 0, rc = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                uc++;
            } else if (c == 'D') {
                dc++;
            } else if (c == 'L') {
                lc++;
            } else if (c == 'R') {
                rc++;
            }
        }
        return uc == dc && lc == rc;
    }
}
// @lc code=end

