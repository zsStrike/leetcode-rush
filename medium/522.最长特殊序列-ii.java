import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=522 lang=java
 *
 * [522] 最长特殊序列 II
 */

// @lc code=start
class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());    
        System.out.println(Arrays.toString(strs));
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            char[] pat = strs[i].toCharArray();
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsqu(pat, pat.length - 1, strs[j].toCharArray(), strs[j].length() - 1)) {
                    // System.out.println("true" + " " + strs[i] + " " + str);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                max = Math.max(max, pat.length);
            }
        }
        return max;
    }
    boolean isSubsqu(char[] pat, int i1, char[] cs, int i2) {
        if (i1 > i2) {
            return false;
        }
        if (i1 == -1) {
            return true;
        }
        if (pat[i1] == cs[i2]) {
            return isSubsqu(pat, i1 - 1, cs, i2 - 1);
        }
        return isSubsqu(pat, i1, cs, i2 - 1);
    }
    
}
// @lc code=end

