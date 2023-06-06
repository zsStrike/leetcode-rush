/*
 * @lc app=leetcode.cn id=1208 lang=java
 *
 * [1208] 尽可能使字符串相等
 */

// @lc code=start
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int count = 0;
        int left = 0, right = 0, n = Math.min(s.length(), t.length());
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int max = 0;
        while (right < n) {
            count += Math.abs(ss[right] - tt[right]);
            while (left <= right && count > maxCost) {
                count -= Math.abs(ss[left] - tt[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
// @lc code=end

