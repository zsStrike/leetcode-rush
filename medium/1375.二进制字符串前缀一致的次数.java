/*
 * @lc app=leetcode.cn id=1375 lang=java
 *
 * [1375] 二进制字符串前缀一致的次数
 */

// @lc code=start
class Solution {
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, flips[i]);
            if (i + 1 == max) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

