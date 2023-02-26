/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    // A -> 0 AA -> 26
    public String convertToTitle(int cn) {
        // A 26
        // AA-ZZ 26 * 26
        // AAA-ZZZ 26 * 26 * 26
        // AAAA-ZZZZ 
        // ZY = 26 + 25 * 26 + 25
        // DCBA = 3 * 26 * 26 * 26 + 26 * 26 * 2 + 26 * 1 + 0
        // columnNumber--;
        // AB = 1 * 26 + 2
        // StringBuilder sb = new StringBuilder();
        // while (columnNumber != 0) {
        //     char c = 'A' - 1;
        //     c += columnNumber % 26;
        //     sb.append(c);
        //     columnNumber--;
        //     columnNumber /= 26;
        // }
        // return sb.reverse().toString();
        StringBuilder sb = new StringBuilder();
        while (cn > 0) {
            cn--;
            sb.append((char)(cn % 26 + 'A'));
            cn /= 26;
        }
        sb.reverse();
        return sb.toString();        
    }
}
// @lc code=end

