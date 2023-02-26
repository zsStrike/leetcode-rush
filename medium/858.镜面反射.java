/*
 * @lc app=leetcode.cn id=858 lang=java
 *
 * [858] 镜面反射
 */

// @lc code=start
class Solution {
    double EP = 1e-5;
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        // s * p = r * q
        if (p % 2 == 0) {
            return 2;
        }
        if (q % 2 == 0) {
            return 0;
        }
        return 1;
    }
}
// @lc code=end

