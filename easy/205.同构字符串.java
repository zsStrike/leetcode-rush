import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                continue;
            }
            if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
// @lc code=end

