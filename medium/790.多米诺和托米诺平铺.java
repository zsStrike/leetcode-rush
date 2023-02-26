import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=790 lang=java
 *
 * [790] 多米诺和托米诺平铺
 */

// @lc code=start
class Solution {
    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long[] ans = new long[n + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
            for (int j = i - 3; j >= 0; j--) {
                ans[i] += ans[j] * 2;
                ans[i] %= 1000_000_007;
            }
        }
        return (int)ans[n];
    }
}
// @lc code=end

