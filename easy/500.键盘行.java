import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> list = new LinkedList<>();
        for (String word : words) {
            int pre = -1;
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (pre != -1) {
                    if (strs[pre].indexOf(Character.toLowerCase(c)) == -1) {
                        flag = false;
                        break;
                    }
                    continue;
                }
                if (strs[0].indexOf(Character.toLowerCase(c)) != -1) {
                    pre = 0;
                } else if (strs[1].indexOf(Character.toLowerCase(c)) != -1) {
                    pre = 1;
                } else if (strs[2].indexOf(Character.toLowerCase(c)) != -1) {
                    pre = 2;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
// @lc code=end

