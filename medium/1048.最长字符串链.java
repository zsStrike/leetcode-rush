import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1048 lang=java
 *
 * [1048] 最长字符串链
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> maxMap = new HashMap<>();
        for (String word : words) {
            maxMap.put(word, 1);
            int len = word.length();
            map.putIfAbsent(len, new ArrayList<>());
            map.get(len).add(word);
        }
        int max = 1;
        for (int i = 1; i <= 16; i++) {
            if (!map.containsKey(i)) continue;
            if (!map.containsKey(i - 1)) continue;
            for (String word : map.get(i)) {
                for (String pre : map.get(i - 1)) {
                    if (isPre(pre, word)) {
                        maxMap.put(word, Math.max(maxMap.get(word), maxMap.get(pre) + 1));
                    }
                }
                max = Math.max(max, maxMap.get(word));
            }
        }
        // System.out.println(maxMap);
        return max;
    }
    boolean isPre(String pre, String word) {
        int i = pre.length() - 1, j = word.length() - 1;
        while (i >= 0 && j >= 0) {
            if (pre.charAt(i) == word.charAt(j)) {
                i--;
                j--;
            } else {
                j--;
            }
        }
        return i == -1 && j == -1 || i == -1 && j == 0;
    }
}
// @lc code=end

