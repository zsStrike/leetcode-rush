/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    // 100 101 110 111 1000
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                ans[i] = 1;
                num = i;
            } else {
                ans[i] = ans[i - num] + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

