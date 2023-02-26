/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nl = name.length(), nt = typed.length();
        int i = 0, j = 0;
        while (i < nl && j < nt) {
            char c = name.charAt(i), d = typed.charAt(j);
            if (c != d) {
                return false;
            }
            int ni = i;
            while (ni < nl && name.charAt(ni) == c) {
                ni++;
            }
            int nj = j;
            while (nj < nt && typed.charAt(nj) == c) {
                nj++;
            }
            if (ni - i > nj - j) {
                return false;
            }
            i = ni;
            j = nj;
        }
        return i == nl && j == nt;
    }
}
// @lc code=end

