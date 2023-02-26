import java.lang.annotation.Target;

/*
 * @lc app=leetcode.cn id=777 lang=java
 *
 * [777] 在LR字符串中交换相邻字符
 */

// @lc code=start
class Solution {
    // XL 和 RX 可以被替换，其他不行
    public boolean canTransform(String start, String end) {
        int si = 0, ti = 0;
        int len = start.length();
        while (si < len) {
            int sj = si, tj = ti;
            while (sj < len && start.charAt(sj) == 'X') {
                sj++;
            }
            while (tj < len && end.charAt(tj) == 'X') {
                tj++;
            }
            // System.out.println(sj + " " + tj);
            if (sj == len && tj == len) {
                return true;
            }
            if (sj == len || tj == len) {
                return false;
            }
            if (start.charAt(sj) == 'L' && end.charAt(tj) == 'L') {
                if (sj < tj) {
                    return false;
                }
                si = sj + 1;
                ti = tj + 1;
            } else if (start.charAt(sj) == 'R' && end.charAt(tj) == 'R') {
                if (sj > tj) {
                    return false;
                }
                si = sj + 1;
                ti = tj + 1;
            } else {
                return false;
            }
        }
        while (ti < len) {
            if (end.charAt(ti) != 'X') {
                return false;
            }
            ti++;
        }
        return true;
    }
}
// @lc code=end

