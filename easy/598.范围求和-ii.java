/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 范围求和 II
 */

// @lc code=start
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // int len = ops.length;
        // if (len == 0) {
        //     return m * n;
        // }
        int minx = m, miny = n;
        for (int[] op : ops) {
            minx = Math.min(minx, op[0]);
            miny = Math.min(miny, op[1]);
        }
        return minx * miny;
    }
}
// @lc code=end

