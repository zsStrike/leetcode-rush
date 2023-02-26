/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[s.charAt(i)]++;
        }
        int evenCount = 0;
        int oddCount = 0;
        int sum = 0;
        int max = 0;
        for (int c : count) {
            if (c == 0) {
                continue;
            }
            if (c % 2 == 0) {
                evenCount++;
                sum += c;
            } else {
                oddCount++;
                sum += c - 1;
                max = Math.max(max, c);
            }
        }
        if (evenCount == 0) {
            return max;
        }
        return oddCount > 0 ? 1 + sum : sum;
    }
}
// @lc code=end

