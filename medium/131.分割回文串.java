import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new LinkedList<>();
        dfs(s, 0, new LinkedList<>());
        return ans;
    }
    void dfs(String s, int cur, List<String> res) {
        if (cur == s.length()) {
            ans.add(new LinkedList<>(res));
        }
        int len = s.length();
        for (int i = cur; i < len; i++) {
            if (!isPal(s, cur, i)) {
                continue;
            }
            res.add(s.substring(cur, i + 1));
            dfs(s, i + 1, res);
            res.remove(res.size() - 1);
        }
    }
    boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end

