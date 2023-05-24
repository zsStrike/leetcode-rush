/*
 * @lc app=leetcode.cn id=1017 lang=java
 *
 * [1017] 负二进制转换
 */

// @lc code=start
class Solution {
    public String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int delta = 1;
        while (n != 0) {
            // System.out.println(n + " " + delta);
            if (n % -2 == 0) {
                sb.append(0);
                n /= -2;
            } else {
                sb.append(1);
                n = (n - delta) / -2;
            }
            // delta = -delta;
        }
        // System.out.println(sb);
        return sb.reverse().toString();
    }
}
// @lc code=end

