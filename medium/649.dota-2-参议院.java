/*
 * @lc app=leetcode.cn id=649 lang=java
 *
 * [649] Dota2 参议院
 */

// @lc code=start
class Solution {
    // DDRRR D
    public String predictPartyVictory(String senate) {
        int rcount = 0, dcount = 0;
        char[] cs = senate.toCharArray();
        for (char c : cs) {
            if (c == 'R') rcount++;
            if (c == 'D') dcount++;
        }
        while (true) {
            System.out.println(cs);
            int n = cs.length;
            for (int i = 0; i < n; i++) {
                if (cs[i] == 'R') {
                    for (int j = 1; j < n; j++) {
                        int idx = (i + j) % n;
                        if (cs[idx] == 'D') {
                            dcount--;
                            cs[idx] = 'X';
                            break;
                        }
                    }
                } else if (cs[i] == 'D') {
                    for (int j = 1; j < n; j++) {
                        int idx = (i + j) % n;
                        if (cs[idx] == 'R') {
                            rcount--;
                            cs[idx] = 'X';
                            break;
                        }
                    }                    
                }
                if (dcount == 0) {
                    return "Radiant";
                }
                if (rcount == 0) {
                    return "Dire";
                }
            }
        }
        // return "";
    }
}
// @lc code=end

