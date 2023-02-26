import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        boolean[] show = new boolean[26];
        int n = words.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(show, false);
            for (char c : words[i].toCharArray()) {
                show[c - 'a'] = true;
            }
            for (int k = i + 1; k < n; k ++) {
                int len = words[k].length();
                int j;
                for (j = 0; j < len; j++) {
                    char c = words[k].charAt(j);
                    if (show[c - 'a']) {
                        break;
                    }
                }
                if (j == len) {
                    // System.out.println(words[i]);
                    max = Math.max(max, words[i].length() * len);
                }
            }
        }
        return max;
    }
}
// @lc code=end

