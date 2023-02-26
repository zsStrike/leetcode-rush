import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedStr = Arrays.stream(banned).collect(Collectors.toSet());
        HashMap<String, Integer> map = new HashMap<>();
        int len = paragraph.length();
        int left = 0;
        while (left < len) {
            while (left < len && !Character.isLetter(paragraph.charAt(left))) {
                left++;
            }
            if (left == len) {
                break;
            }
            int right = left;
            while (right < len && Character.isLetter(paragraph.charAt(right))) {
                right++;
            }
            String key = paragraph.substring(left, right);
            key = key.toLowerCase();
            if (!bannedStr.contains(key)) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            left = right;
        }
        int max = 0;
        String ans = "";
        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
}
// @lc code=end

