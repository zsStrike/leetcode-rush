import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=481 lang=java
 *
 * [481] 神奇字符串
 */

// @lc code=start
class Solution {

    static char[] cs = new char[100_000];
    static int[] count = new int[100_000];
    static {
        cs[0] = '1';
        cs[1] = '2';
        int i = 1, j = 1;
        char cur = '2';
        while (i < 100_000) {
            int times = cs[j] - '0';
            while (times > 0) {
                cs[i] = cur;
                times--;
                i++;
            }
            j++;
            cur = cur == '2' ? '1' : '2';
        }
        count[0] = 1;
        for (i = 1; i < cs.length; i++) {
            count[i] = count[i - 1] + (cs[i] == '1' ? 1 : 0);
        }
    }

    public int magicalString(int n) {
        return count[n - 1];
    }
}
// @lc code=end

