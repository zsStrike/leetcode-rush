/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 */

// @lc code=start
class Solution {
    public String alphabetBoardPath(String target) {
        char[] cs = target.toCharArray();
        int len = cs.length;
        int pi = 0;
        int pj = 0;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < len; k++) {
            char c = cs[k];
            int i = (c - 'a') / 5;
            int j = (c - 'a') % 5;
            int di = i - pi;
            int dj = j - pj;
            if (c == 'z') {
                if (dj < 0) {
                    while (dj != 0) {
                        sb.append('L');
                        dj++;
                    }
                } else if (dj > 0) {
                    while (dj != 0) {
                        sb.append('R');
                        dj--;
                    }
                }    
                if (di < 0) {
                    while (di != 0) {
                        sb.append('U');
                        di++;
                    }
                } else if (di > 0) {
                    while (di != 0) {
                        sb.append('D');
                        di--;
                    }
                }            
            } else {
                if (di < 0) {
                    while (di != 0) {
                        sb.append('U');
                        di++;
                    }
                } else if (di > 0) {
                    while (di != 0) {
                        sb.append('D');
                        di--;
                    }
                }
                if (dj < 0) {
                    while (dj != 0) {
                        sb.append('L');
                        dj++;
                    }
                } else if (dj > 0) {
                    while (dj != 0) {
                        sb.append('R');
                        dj--;
                    }
                }
            }
            pi = i;
            pj = j;
            sb.append('!');
        }
        return sb.toString();
    }
}
// @lc code=end

