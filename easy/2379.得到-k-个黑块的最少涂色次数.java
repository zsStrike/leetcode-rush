/*
 * @lc app=leetcode.cn id=2379 lang=java
 *
 * [2379] 得到 K 个黑块的最少涂色次数
 */

// @lc code=start
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = 0;
        char[] cs = blocks.toCharArray();
        int n = blocks.length();
        int min = k;
        int tmp = 0;
        while (right < n) {
            if (cs[right] == 'W') tmp++;
            while (right - left >= k) {
                if (cs[left] == 'W') tmp--;
                left++;
            }
            if (right - left + 1 == k) {
                min = Math.min(min, tmp);
            }
            right++;
        }
        return min;
    }
}
// @lc code=end

