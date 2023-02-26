import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 统计各位数字都不同的数字个数
 */

// @lc code=start
class Solution {
    // X   9
    // XX  9 * 9
    // XXX 9 * 9 * 8
    static int[] dp = new int[9];
    static {
        dp[0] = 1;
        dp[1] = 9;
        int count = 9;
        for (int i = 2; i < 9; i++) {
            dp[i] = dp[i - 1] * count;
            count--;
        }
    }
    
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
// @lc code=end

