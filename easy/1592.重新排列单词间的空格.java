import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
        LinkedList<String> list = new LinkedList<>();
        int left = 0, n = text.length();
        while (left < n) {
            if (text.charAt(left) == ' ') {
                spaces++;
                left++;
            } else {
                int right = left;
                while (right < n && text.charAt(right) != ' ') {
                    right++;
                }
                list.add(text.substring(left, right));
                left = right;
            }
        }
        int count = list.size();
        StringBuilder sb = new StringBuilder();
        if (count == 1) {
            sb.append(list.get(0));
            for (int i = 0; i < spaces; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int delta = spaces / (count - 1);
        for (String str : list) {
            sb.append(str);
            for (int i = 0; i < delta; i++) {
                sb.append(" ");
            }
        }
        sb.delete(sb.length() - delta, sb.length());
        for (int i = 0; i < spaces % (count - 1); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
// @lc code=end

