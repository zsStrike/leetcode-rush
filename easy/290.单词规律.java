import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i])) {
                    return false;
                }
            } else {
                map.put(c, strs[i]);
            }
        }
        return map.size() == map.values().stream().distinct().count();
    }
}
// @lc code=end

