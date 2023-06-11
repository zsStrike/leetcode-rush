import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        if (s == "") return true;
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
// @lc code=end

