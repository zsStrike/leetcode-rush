/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        if (n == 2) {
            return 1;
        }
        int count = 1;
        int i = 1;
        for (i = 1; i < n; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        if (i == n - 1) {
            return scoreOfParentheses(s.substring(1, n - 1)) * 2;
        }
        return scoreOfParentheses(s.substring(0, i + 1)) + scoreOfParentheses(s.substring(i + 1, n));
    }
}
// @lc code=end

