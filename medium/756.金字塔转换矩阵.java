import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=756 lang=java
 *
 * [756] 金字塔转换矩阵
 */

// @lc code=start
class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (memo.containsKey(bottom)) {
            return memo.get(bottom);
        }
        int len = bottom.length();
        if (len == 2) {
            for (String pat : allowed) {
                if (pat.startsWith(bottom)) {
                    return true;
                }
            }
            return false;
        }
        boolean res = dfs(bottom, allowed, new StringBuilder(), 0);
        memo.put(bottom, res);
        return res;
    }
    private boolean dfs(String bottom, List<String> allowed, StringBuilder sb, int cur) {
        int len = bottom.length();
        if (cur == len - 1) {
            return pyramidTransition(sb.toString(), allowed);
        }
        String prefix = bottom.substring(cur, cur + 2);
        for (String pat : allowed) {
            if (pat.startsWith(prefix)) {
                sb.append(pat.charAt(2));
                if (dfs(bottom, allowed, sb, cur + 1)) {
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}
// @lc code=end

