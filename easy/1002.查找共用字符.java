import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找共用字符
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] words) {
        int len = words.length;
        if (len == 1) {
            return Arrays.asList(words[0].split(""));
        }
        HashMap<Character, Integer> pre = getMap(words[0]);
        HashMap<Character, Integer> cur;
        HashMap<Character, Integer> common = pre;
        for (int i = 1; i < len; i++) {
            cur = getMap(words[i]);
            common = compare(pre, cur);
            pre = common;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : common.keySet()) {
            int i = common.get(c);
            while (i > 0) {
                sb.append(c);
                i--;
            }
        }
        if (sb.length() == 0) {
            return new LinkedList<>();
        }
        return Arrays.asList(sb.toString().split(""));
    }
    public HashMap<Character, Integer> getMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
    public HashMap<Character, Integer> compare(HashMap<Character, Integer> pre, HashMap<Character, Integer> cur) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : pre.keySet()) {
            if (cur.containsKey(c)) {
                map.put(c, Math.min(pre.get(c), cur.get(c)));
            }
        }
        return map;
    }
}
// @lc code=end

