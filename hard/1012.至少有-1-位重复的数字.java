import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1012 lang=java
 *
 * [1012] 至少有 1 位重复的数字
 */

// @lc code=start
class Solution {
    public int numDupDigitsAtMostN(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        HashSet<Character> set = new HashSet<>();
        return helper(cs, 0, set);
    }
    int helper(char[] cs, int start, HashSet<Character> set) {
        if (start == cs.length) return 0;
        int end = cs.length;
        char cur = cs[start];
        int ans = 0;
        for (char c = '0'; c < cur; c++) {
            if (set.contains(c)) {
                ans += Math.pow(10, end - start - 1) - 1;
            } else {
                set.add(c);
                ans += helper(cs, start + 1, set);
                set.remove(c);
            }
        }
        if (set.contains(cur)) {
            if (start == end - 1) {
                ans += 1;
            } else {
                ans += Integer.parseInt(String.valueOf(Arrays.copyOfRange(cs, start + 1, end)));
            }
        } else {
            set.add(cur);
            ans += helper(cs, start + 1, set);
            set.remove(cur);
        }
        return ans;
    }
}
// @lc code=end

