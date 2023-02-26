/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    // 10 3 3.3
    // 10 3 3 4
    // 10 2 2 3 3
    // 14 4 5 5
    // 14 3 3 4 4 16 * 9 = 
    // 162 = 9 9 2 = 3 3 3 3 2
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int max = 0;
        for (int k = 2; k <= n; k++) {
            int mul = n / k;
            int mod = n % k;
            int num = (int)(Math.pow(mul + 1, mod) * Math.pow(mul, k - mod));
            max = Math.max(max, num);
        }
        return max;
    }
}
// @lc code=end

