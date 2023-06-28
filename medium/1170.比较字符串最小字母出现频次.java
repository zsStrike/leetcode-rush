/*
 * @lc app=leetcode.cn id=1170 lang=java
 *
 * [1170] 比较字符串最小字母出现频次
 */

// @lc code=start
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int a = f(queries[i]);
            int count = 0;
            for (String str : words) {
                if (a < f(str)) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
    int f(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return count[i];
            }
        }
        return 0;
    }
}
// @lc code=end

