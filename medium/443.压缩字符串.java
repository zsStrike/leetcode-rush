/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int start = 0;
        int end = 0;
        int n = chars.length;
        int count = 0;
        int idx = 0;
        while (start < n) {
            while (end < n && chars[end] == chars[start]) {
                end++;
            }
            int len = end - start;
            chars[idx] = chars[start];
            idx++;
            if (len == 1) {
                count++;
            } else {
                count += 1 + String.valueOf(len).length();
                for (char c : String.valueOf(len).toCharArray()) {
                    chars[idx] = c;
                    idx++;
                }
            }
            start = end;
        }
        return count;
    }
}
// @lc code=end

