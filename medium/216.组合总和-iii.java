import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, n, k, 1, new LinkedList<>());
        return ans;    
    }
    private void dfs(int sum, int n, int left, int start, List<Integer> res) {
        if (left == 0 && sum == n) {
            ans.add(new LinkedList<>(res));
            return;
        }
        for (int i = start; i <= 9; i++) {
            sum += i;
            res.add(i);
            dfs(sum, n, left - 1, i + 1, res);
            sum -= i;
            res.remove(res.size() - 1);
        }
    }
}
// @lc code=end

