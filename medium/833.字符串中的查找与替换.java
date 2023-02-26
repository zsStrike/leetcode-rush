import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=833 lang=java
 *
 * [833] 字符串中的查找与替换
 */

// @lc code=start
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = indices.length;
        int n = s.length();
        for (int i = 0; i < k; i++) {
            int j = indices[i];
            int offset = 0;
            while (j + offset < n && offset < sources[i].length() && s.charAt(j + offset) == sources[i].charAt(offset)) {
                offset++;
            }
            if (offset == sources[i].length()) {
                map.put(j, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < n) {
            if (!map.containsKey(idx)) {
                sb.append(s.charAt(idx));
                idx++;
            } else {
                sb.append(targets[map.get(idx)]);
                idx += sources[map.get(idx)].length();
            }
        }
        return sb.toString();
    }
}
// @lc code=end

