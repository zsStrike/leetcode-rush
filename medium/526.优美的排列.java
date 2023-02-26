/*
 * @lc app=leetcode.cn id=526 lang=java
 *
 * [526] 优美的排列
 */

// @lc code=start
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        dfs(new boolean[n + 1], 1, n);
        return count;
    }
    void dfs(boolean[] visisted, int idx, int n) {
        if (idx == n + 1) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visisted[i]) {
                continue;
            }
            if (i % idx == 0 || idx % i == 0) {
                visisted[i] = true;
                dfs(visisted, idx + 1, n);
                visisted[i] = false;
            }
        }
    }
}
// @lc code=end

