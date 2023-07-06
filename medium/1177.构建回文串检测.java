/*
 * @lc app=leetcode.cn id=1177 lang=java
 *
 * [1177] 构建回文串检测
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        // from 1..n + 1
        int[][] count = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            count[i] = Arrays.copyOf(count[i - 1], 26);
            count[i][cs[i - 1] - 'a']++;
        }
        List<Boolean> ans = new LinkedList<>();
        for (int[] query : queries) {
            int[] left = count[query[0]];
            int[] right = count[query[1] + 1];
            int res = 0;
            for (int i = 0; i < 26; i++) {
                int tmp = right[i] - left[i];
                if (tmp % 2 != 0) {
                    res++;
                }
            }
            if (res / 2 > query[2]) {
                ans.add(false);
            } else {
                ans.add(true);
            }
        }
        return ans;
    }
}
// @lc code=end

