/*
 * @lc app=leetcode.cn id=831 lang=java
 *
 * [831] 隐藏个人信息
 */

// @lc code=start
class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            return maskEmail(s);
        }
        return maskPhoneNumber(s);
    }
    String maskEmail(String s) {
        s = s.toLowerCase();
        String[] ss = s.split("@");
        StringBuilder sb = new StringBuilder();
        sb.append(ss[0].charAt(0));
        sb.append("*****");
        sb.append(ss[0].charAt(ss[0].length() - 1));
        sb.append("@");
        sb.append(ss[1]);
        return sb.toString();
    }
    String maskPhoneNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (sb.length() == 10) {
            ans.append("");
        } else if (sb.length() == 11) {
            ans.append("+*-");
        } else if (sb.length() == 12) {
            ans.append("+**-");
        } else if (sb.length() == 13) {
            ans.append("+***-");
        }
        ans.append("***-***-");
        ans.append(sb.substring(sb.length() - 4));
        return ans.toString();
    }
}
// @lc code=end

