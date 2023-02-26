import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n]; // dp[i] s[..i]
        HashSet<String> set = new HashSet<>(wordDict);
        // init
        for (int i = 1; i <= n; i++) {
            if (set.contains(s.substring(0, i))) {
                dp[i - 1] = true;
            }
        }
        // dp
        for (int i = 1; i < n; i++) {
            // System.out.println(Arrays.toString(dp));
            if (dp[i]) {
                continue;
            }
            for (int j = i; j > 0; j--) {
                if (set.contains(s.substring(j, i + 1)) && dp[j - 1]) {
                    dp[i] = true;
                    break;
                }
            } 
        }
        return dp[n - 1];
    }
}
// @lc code=end

