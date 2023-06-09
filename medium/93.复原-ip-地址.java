import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        dfs(s.toCharArray(), 0, ans, new StringBuilder(), 0);
        return ans;
    }
    void dfs(char[] cs, int cur, List<String> ans, StringBuilder sb, int count) {
        int len = cs.length;
        if (cur == len) {
            if (count == 4) {
                ans.add(sb.substring(0, sb.length() - 1).toString());
            }
            return;
        }
        int sum = cs[cur] - '0';
        int sbLen = sb.length();
        if (sum == 0) {
            sb.append(sum).append(".");
            dfs(cs, cur + 1, ans, sb, count + 1);
            sb.setLength(sbLen);
            return;
        }
        while (cur < len && sum != 0 && sum < 256) {
            sb.append(sum).append(".");
            dfs(cs, cur + 1, ans, sb, count + 1);
            sb.setLength(sbLen);
            cur++;
            if (cur == len) break;
            sum = sum * 10 + cs[cur] - '0';
        }
    }
}
// @lc code=end

