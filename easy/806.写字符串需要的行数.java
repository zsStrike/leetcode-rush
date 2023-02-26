package easy;

/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int rows = 0;
        int n = s.length();
        int left = 0;
        int count = 0;
        while (left < n) {
            int right = left;
            count = 0;
            while (right < n && count + widths[s.charAt(right) - 'a'] <= 100) {
                count += widths[s.charAt(right) - 'a'];
                right++;
            }
            rows++;
            left = right;
        }
        return new int[] {rows, count};
    }
}
// @lc code=end

