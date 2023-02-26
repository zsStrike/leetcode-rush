/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < n && !Character.isLetter(cs[left])) {
                left++;
            }
            while (right >= 0 && !Character.isLetter(cs[right])) {
                right--;
            }
            // System.out.println(left + " " + right);
            if (left < right) {
                cs[left] = s.charAt(right);
                cs[right] = s.charAt(left);
                left++;
                right--;
            }
            // System.out.println(cs);
        }
        return String.valueOf(cs);
    }
}
// @lc code=end

