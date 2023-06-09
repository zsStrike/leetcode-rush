import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = ")}]".indexOf(c);
            if (idx != -1) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != "({[".charAt(idx)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

