import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, 100000);
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cs[i] == c) {
                ans[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                int left = i - 1;
                while (left >= 0 && ans[left] != 0) {
                    ans[left] = Math.min(ans[left], i - left);
                    left--;
                }
                int right = i + 1;
                while (right < n && ans[right] != 0) {
                    ans[right] = Math.min(ans[right], right - i);
                    right++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

