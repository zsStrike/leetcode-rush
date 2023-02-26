import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    HashMap<String, Integer> map;
    public int longestSubstring(String s, int k) {
        map = new HashMap<>();
        char[] cs = s.toCharArray();
        return longestSubstring(cs, k, 0, cs.length - 1);
    }
    int longestSubstring(char[] cs, int k, int start, int end) {
        String key = start + " " + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int total = 0;
        int count = 0;
        int[] freq = new int[26];
        for (int i = start; i <= end; i++) {
            if (freq[cs[i] - 'a'] == 0) {
                total++;
            }
            freq[cs[i] - 'a']++;
            if (freq[cs[i] - 'a'] == k) {
                count++;
            }
        }
        if (count == total) {
            return end - start + 1;
        }
        while (start <= end && count != total) {
            if (freq[cs[start] - 'a'] < k) {
                freq[cs[start] - 'a']--;
                if (freq[cs[start] - 'a'] == 0) {
                    total--;
                }
                start++;
                continue;
            }
            if (freq[cs[end] - 'a'] < k) {
                if (freq[cs[end] - 'a'] == 1) {
                    total--;
                }
                freq[cs[end] - 'a']--;
                end--;
                continue;
            }
            int max = Math.max(longestSubstring(cs, k, start + 1, end), longestSubstring(cs, k, start, end - 1));
            map.put(key, max);
            return max;
            
        }
        map.put(key, end - start + 1);
        return end - start + 1;
    }
}
// @lc code=end

