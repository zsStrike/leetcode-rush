/*
 * @lc app=leetcode.cn id=880 lang=java
 *
 * [880] 索引处的解码字符串
 */

// @lc code=start
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;
            if (k == 0 && Character.isLetter(c)) {
                return s.substring(i, i + 1);
            }
            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size--;
            }
            
        }
        return "";
    }
}
// @lc code=end

