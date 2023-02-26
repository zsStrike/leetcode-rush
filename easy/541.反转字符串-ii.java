/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int start = 0;
        boolean reverse = true;
        int len = s.length();
        char[] cs = s.toCharArray();
        while (start < len) {
            int end = start + k - 1 > len - 1 ? len - 1 : start + k - 1;
            if (reverse) {
                int left = start, right = end;
                while (left < right) {
                    char tmp = cs[left];
                    cs[left] = cs[right];
                    cs[right] = tmp;
                    left++;
                    right--;
                }
            }
            reverse = !reverse;
            start = end + 1;
        }
        return String.valueOf(cs);
    }
}
// @lc code=end

