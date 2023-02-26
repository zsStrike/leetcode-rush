/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    int idx = (i + j) % len;
                    if (s.charAt(idx) != goal.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}
// @lc code=end

