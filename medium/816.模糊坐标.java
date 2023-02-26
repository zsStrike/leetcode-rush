import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=816 lang=java
 *
 * [816] 模糊坐标
 */

// @lc code=start
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        char[] cs = Arrays.copyOfRange(s.toCharArray(), 1, s.length() - 1);
        int n = cs.length;
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            // [0..i] [i+1..]
            List<String> lefts = validPos(cs, 0, i);
            List<String> rights = validPos(cs, i + 1, n - 1);
            StringBuilder sb = new StringBuilder();
            for (String left : lefts) {
                for (String right : rights) {
                    sb.append("(");
                    sb.append(left);
                    sb.append(", ");
                    sb.append(right);
                    sb.append(")");
                    ans.add(sb.toString());
                    sb.setLength(0);                    
                }
            } 
        }
        return ans;
    }
    List<String> validPos(char[] cs, int left, int right) {
        List<String> ans = new LinkedList<>();
        for (int i = left; i < right; i++) {
            // [left..i] [i+1, right]
            // 00 001
            if (cs[left] == '0' && i > left) {
                continue;
            }
            if (cs[right] == '0') {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(cs, left, right - left + 1);
            sb.insert(i - left + 1, ".");
            ans.add(sb.toString());
        }
        if (cs[left] != '0' || right == left) {
            ans.add(String.valueOf(cs, left, right - left + 1));
        }
        return ans;
    }
}
// @lc code=end

