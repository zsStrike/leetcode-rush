import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=823 lang=java
 *
 * [823] 带因子的二叉树
 */

// @lc code=start
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1000_000_007;
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    dp[i] += dp[j] * dp[map.get(arr[i] / arr[j])];
                    dp[i] %= MOD;
                }
            }
        }
        long sum = 0;
        for (long a : dp) {
            sum += a;
            sum %= MOD;
        }
        return (int) sum;
    }
}
// @lc code=end

