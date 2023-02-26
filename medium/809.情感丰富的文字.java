/*
 * @lc app=leetcode.cn id=809 lang=java
 *
 * [809] 情感丰富的文字
 */

// @lc code=start
class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            int sp = 0, wp = 0;
            int wordLen = word.length(), sLen = s.length();
            while (sp < sLen && wp < wordLen) {
                if (s.charAt(sp) != word.charAt(wp)) {
                    break;
                }
                int sn = sp, wn = wp;
                while (sn < sLen && s.charAt(sn) == s.charAt(sp)) {
                    sn++;
                }
                while (wn < wordLen && word.charAt(wn) == word.charAt(wp)) {
                    wn++;
                }
                int len1 = sn - sp, len2 = wn - wp;
                if (len1 == len2 || len2 < len1 && len1 >= 3) {
                    sp = sn;
                    wp = wn;
                } else {
                    break;
                }
            }
            if (sp == sLen && wp == wordLen) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

