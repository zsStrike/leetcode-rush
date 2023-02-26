/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    // 35 / 3 = 12
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i < len; i++) {
            // if (num.charAt(i) == '0') {
            //     continue;
            // }
            for (int j = i + 1; j < len; j++) {
                if (num.charAt(0) == '0' && i > 1) {
                    continue;
                }
                long first = Long.parseLong(num.substring(0, i));
                if (num.charAt(i) == '0' && j > i + 1) {
                    continue;
                }
                long second = Long.parseLong(num.substring(i, j));
                long cur = first + second;
                if (test(num, j, cur, second)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean test(String num, int idx, long cur, long second) {
        if (idx == num.length()) {
            return true;
        }
        String pat = cur + "";
        int len = pat.length();
        int i = 0;
        while (i < len && idx + i < num.length() && pat.charAt(i) == num.charAt(idx + i)) {
            i++;
        }
        if (i != len) {
            return false;
        }
        return test(num, idx + i, cur + second, cur);
    }
}
// @lc code=end

