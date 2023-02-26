/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        return countSubstrings(s.toCharArray());
    }

    public int countSubstrings(char[] cs) {
        int n = cs.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (issub(cs, i, j)) {
                    count++;
                }                
                // if (cs[i] == cs[j]) {
                //     if (issub(cs, i, j)) {
                //         count++;
                //     }
                // }
            }
        }
        return count;
    }

    boolean issub(char[] cs, int left, int right) {
        while (left < right) {
            if (cs[left] != cs[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

