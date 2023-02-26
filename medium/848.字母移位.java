/*
 * @lc app=leetcode.cn id=848 lang=java
 *
 * [848] 字母移位
 */

// @lc code=start
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        for (int i = 0; i < n; i++) {
            shifts[i] %= 26;
        }
        for (int i = n - 2; i >= 0; i--) {
            shifts[i] = shifts[i] + shifts[i + 1];
            shifts[i] %= 26;
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cs[i] + shifts[i] <= 'z') {
                cs[i] += shifts[i];
            } else {
                cs[i] = (char) ('a' + (cs[i] + shifts[i] - 'z' - 1));
            }
        }
        return String.valueOf(cs);
    }
}
// @lc code=end

