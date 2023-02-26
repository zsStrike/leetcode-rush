import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=929 lang=java
 *
 * [929] 独特的电子邮件地址
 */

// @lc code=start
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String email : emails) {
            String[] data = email.split("@");
            map.putIfAbsent(data[1], new HashSet<>());
            map.get(data[1]).add(validate(data[0]));
        }
        return map.values().stream().mapToInt(a -> a.size()).sum();
    }
    String validate(String name) {
        int idx = name.indexOf("+");
        if (idx != -1) {
            name = name.substring(0, idx);
        }
        return name.replaceAll("\\.", "");
    }
}
// @lc code=end

