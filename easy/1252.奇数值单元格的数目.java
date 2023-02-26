/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] a1 = new int[m];
        int[] a2 = new int[n];
        for (int[] idx : indices) {
            a1[idx[0]]++;
            a2[idx[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((a1[i] + a2[j]) % 2 != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

