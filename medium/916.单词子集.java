import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=916 lang=java
 *
 * [916] 单词子集
 */

// @lc code=start
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        HashMap<Character, Integer> w2m = new HashMap<>();
        for (int i = 0; i < words2.length; i++) {
            HashMap<Character, Integer> map = getMap(words2[i]);
            for (char c : map.keySet()) {
                w2m.put(c, Math.max(w2m.getOrDefault(c, 0), map.get(c)));
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < words1.length; i++) {
            HashMap<Character, Integer> map = getMap(words1[i]);
            boolean flag = true;
            for (char c : w2m.keySet()) {
                if (map.getOrDefault(c, 0) < w2m.get(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(words1[i]);
        }
        return ans;
    }
    HashMap<Character, Integer> getMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
// @lc code=end

