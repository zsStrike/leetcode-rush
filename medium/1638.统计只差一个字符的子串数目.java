import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1638 lang=java
 *
 * [1638] 统计只差一个字符的子串数目
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen > tlen) {
            return countSubstrings(t.toCharArray(), s.toCharArray());
        }
        return countSubstrings(s.toCharArray(), t.toCharArray());
    }
    private int countSubstrings(char[] ss, char[] ls) {
        int ans = 0;
        int minLen = ss.length, maxLen = ls.length;
        for (int len = 1; len <= minLen; len++) {
            for (int i = 0; i <= minLen - len; i++) {
                for (int j = 0; j <= maxLen - len; j++) {
                    if (isValid(ss, i, ls, j, len)) {
                        // System.out.println(i + " " + j + " " + len);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private boolean isValid(char[] ss, int si, char[] ls, int li, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (ss[i + si] != ls[i + li]) {
                count++;
                if (count == 2) return false;
            }
        }
        return count == 1;
    }
}
// @lc code=end

