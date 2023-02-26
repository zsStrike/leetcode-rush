/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = columnTitle.charAt(i) - 'A' + 1;
            System.out.println(c);
            ans = ans * 26 + c;
        }
        return ans;
    }
}
// @lc code=end

