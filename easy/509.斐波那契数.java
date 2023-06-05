/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int p2 = 0, p1 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = p2 + p1;
            p2 = p1;
            p1 = tmp;
        }
        return p1;
    }
}
// @lc code=end

