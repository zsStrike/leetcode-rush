/*
 * @lc app=leetcode.cn id=1247 lang=java
 *
 * [1247] 交换字符使得字符串相同
 */

// @lc code=start
class Solution {
    public int minimumSwap(String s1, String s2) {
        // s1[i..] s2[i..] 交换相同
        // xxyyxyxyxx
        // xyyxyxxxyx
        // (x, y) 3 1 1
        // (y, x) 3 1 1
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int a = 0, b = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[i]) {
                continue;
            }
            if (c1[i] == 'x') {
                a++;
            } else {
                b++;
            }
        }
        int ans = a / 2 + b / 2;
        a %= 2;
        b %= 2;
        if ((a ^ b) == 1) {
            return -1;
        }
        if (a == 0) {
            return ans;
        }
        return ans + 2;
    }
}
// @lc code=end

