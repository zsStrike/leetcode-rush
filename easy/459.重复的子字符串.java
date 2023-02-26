/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = 1;
        int n = s.length();
        while (len < n) {
            if (n % len != 0) {
                len++;
                continue;
            }
            if (!s.substring(0, len).equals(s.substring(n - len, n))) {
                len++;
                continue;
            }
            String str = s.substring(0, len);
            boolean flag = true;
            for (int i = len; i < n; i += len) {
                if (!str.equals(s.substring(i, i + len))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            len++;
        }
        return false;
    }
}
// @lc code=end

