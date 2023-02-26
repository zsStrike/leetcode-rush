/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 */

// @lc code=start
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = Math.max(rec1[0], rec2[0]);
        int y1 = Math.max(rec1[1], rec2[1]);
        int x2 = Math.min(rec1[2], rec2[2]);
        int y2 = Math.min(rec1[3], rec2[3]);
        if (x1 < x2 && y1 < y2) {
            return true;
        }
        return false;
    }
    boolean isInRec(int[] rec, int x, int y) {
        // 左下 rec[0] rec[1]
        // 左上 rec[0] rec[3]
        // 右上 rec[2] rec[3]
        // 右下 rec[2] rec[1]
        if (x > rec[0] && y > rec[1]
            && x < rec[2] && y < rec[3]) {
                return true;
            }
        return false;
    }
}
// @lc code=end

