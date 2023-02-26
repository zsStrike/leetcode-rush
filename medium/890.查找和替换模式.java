import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=890 lang=java
 *
 * [890] 查找和替换模式
 */

// @lc code=start
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new LinkedList<>();
        int n = pattern.length();
        for (String word : words) {
            HashMap<Character, Character> map = new HashMap<>();
            HashSet<Character> visisted = new HashSet<>();
            boolean find = true;
            for (int i = 0; i < n; i++) {
                char key = word.charAt(i);
                char value = pattern.charAt(i);
                if (map.containsKey(key)) {
                    if (map.get(key) != value) {
                        find = false;
                        break;
                    }
                } else {
                    if (visisted.contains(value)) {
                        find = false;
                        break;
                    }
                    map.put(key, value);
                    visisted.add(value);
                }
            }
            if (find) {
                ans.add(word);
            }
        }
        return ans;
    }
}
// @lc code=end

