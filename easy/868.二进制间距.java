/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    public int binaryGap(int n) {
        String num = Integer.toBinaryString(n);
        n = num.length();
        int left = 0;
        int max = 0;
        while (left < n) {
            while (left < n && num.charAt(left) != '1') {
                left++;
            }
            int right = left + 1;
            while (right < n && num.charAt(right) != '1') {
                right++;
            }
            if (right != n) {
                max = Math.max(max, right - left);
            }
            left = right;
        }
        return max;
    }
}
// @lc code=end

