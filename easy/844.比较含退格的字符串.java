/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return decode(s).equals(decode(t));
    }
    String decode(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("#") != -1) {
            int idx = sb.indexOf("#");
            if (idx == 0) {
                sb.delete(idx, idx + 1);
            } else {
                sb.delete(idx - 1, idx + 1);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

