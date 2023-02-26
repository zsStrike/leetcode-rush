import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (c == '-') {

            } else if (Character.isDigit(c)) {
                sb.insert(0, c);
            } else if (Character.isLetter(c)) {
                sb.insert(0, Character.toUpperCase(c));
            }
            if (sb.length() == k) {
                stack.push(sb.toString());
                sb.setLength(0);
            }
            i--;
        }
        if (sb.length() != 0) {
            stack.push(sb.toString());
        }
        sb.setLength(0);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append("-");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
// @lc code=end

