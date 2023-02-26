import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.remove(c);
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
            }
        }
        for (char c : map.keySet()) {
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

