import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int ans = 0;
        ArrayList<Integer> count = new ArrayList<>();
        int start = 0;
        while (start < n) {
            int end = start;
            while (end < n && s.charAt(start) == s.charAt(end)) {
                end++;
            }
            count.add(end - start);
            start = end;
        }
        int size = count.size();
        for (int i = 0; i < size - 1; i++) {
            ans += Math.min(count.get(i), count.get(i + 1));
        }
        return ans;
    }
}
// @lc code=end

