import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=1023 lang=java
 *
 * [1023] 驼峰式匹配
 */

// @lc code=start
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        LinkedList<Boolean> ans = new LinkedList<>();
        for (String query : queries) {
            int i = 0, j = 0;
            while (i < query.length() && j < pattern.length()) {
                if (pattern.charAt(j) == query.charAt(i)) {
                    i++;
                    j++;
                } else if (Character.isUpperCase(query.charAt(i))) {
                    break;
                } else {
                    i++;
                }
            }
            if (j == pattern.length()) {
                while (i < query.length() && Character.isLowerCase(query.charAt(i))) {
                    i++;
                }
                ans.add(i == query.length());
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
// @lc code=end

