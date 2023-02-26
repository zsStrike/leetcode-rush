import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1016 lang=java
 *
 * [1016] 子串能表示从 1 到 N 数字的二进制串
 */

// @lc code=start
class Solution {
    public boolean queryString(String s, int n) {
        int len = s.length();
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                if (s.charAt(j) == '0') {
                    continue;
                }
                set.add(s.substring(j, j + i));
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

