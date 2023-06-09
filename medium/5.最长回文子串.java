/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int max = 1;
        String ans = "" + cs[0];
        String tmp = "";
        for (int i = 1; i < cs.length; i++) {
            int j;
            if ((j = longestPalindrome(cs, i - 1, i)) > max) {
                max = j;
                ans = String.valueOf(cs, i - max / 2, max);
            }
            if ((j = longestPalindrome(cs, i, i)) > max) {
                max = j;
                ans = String.valueOf(cs, i - max / 2, max);
            }
            // System.out.println(j + " " + ans);
        }
        return ans;
    }
    int longestPalindrome(char[] cs, int left, int right) {
        int n = cs.length;
        while (left >= 0 && right < n && cs[left] == cs[right]) {
            left--;
            right++;
        } 
        return right - left - 1;
    }
}
// @lc code=end

