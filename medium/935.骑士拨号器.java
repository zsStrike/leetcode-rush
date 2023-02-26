import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=935 lang=java
 *
 * [935] 骑士拨号器
 */

// @lc code=start
class Solution {
    static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    static {
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, new HashSet<>());
        }
        map.get(1).addAll(Arrays.asList(6, 8));
        map.get(2).addAll(Arrays.asList(7, 9));
        map.get(3).addAll(Arrays.asList(4, 8));
        map.get(4).addAll(Arrays.asList(0, 3, 9));
        map.get(5).addAll(Arrays.asList());
        map.get(6).addAll(Arrays.asList(0, 1, 7));
        map.get(7).addAll(Arrays.asList(2, 6));
        map.get(8).addAll(Arrays.asList(1, 3));
        map.get(9).addAll(Arrays.asList(2, 4));
        map.get(0).addAll(Arrays.asList(4, 6));
    }
    static int MOD = (int) (1e9 + 7);
    public int knightDialer(int n) {
        // dp[i][j] 表示 i 次移动最后为 j 的数目
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = 0;
                for (int pre : map.get(j)) {
                    dp[i][j] += dp[i - 1][pre];
                    dp[i][j] %= MOD;
                }
            }
        }
        int sum = 0;
        for (int i : dp[n]) {
            sum += i;
            sum %= MOD;
        }
        return sum;
    }
}
// @lc code=end

