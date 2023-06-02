/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int left = 0, right = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int max = 0;
        while (right < n) {
            map[cs[right]]++;
            while (left < n && map[cs[right]] >= 2) {
                map[cs[left]]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
// @lc code=end

