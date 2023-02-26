/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int Acount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                Acount++;
            }
        }
        if (Acount >= 2) {
            return false;
        }
        return s.indexOf("LLL") == -1;
        
    }
}
// @lc code=end

