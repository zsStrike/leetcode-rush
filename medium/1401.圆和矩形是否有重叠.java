/*
 * @lc app=leetcode.cn id=1401 lang=java
 *
 * [1401] 圆和矩形是否有重叠
 */

// @lc code=start
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (yCenter <= y2 && yCenter >= y1 && xCenter <= x2 && xCenter >= x1) {
            return true;
        }
        // 下方
        if (xCenter <= x2 && xCenter >= x1 && yCenter < y1) {
            return y1 - yCenter <= radius;
        }
        // 上方
        if (xCenter <= x2 && xCenter >= x1 && yCenter > y2) {
            return yCenter - y2 <= radius;
        }
        // 左方
        if (yCenter <= y2 && yCenter >= y1 && xCenter < x1) {
            return x1 - xCenter <= radius;
        }
        // 右方
        if (yCenter <= y2 && yCenter >= y1 && xCenter > x2) {
            return xCenter - x2 <= radius;
        }
        // 左上方
        if (xCenter < x1 && yCenter > y2) {
            return (x1 - xCenter) * (x1 - xCenter) + (yCenter - y2) * (yCenter - y2) <= radius * radius;
        }
        // 左下方
        if (xCenter < x1 && yCenter < y1) {
            return (x1 - xCenter) * (x1 - xCenter) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius;
        }        
        // 左上方
        if (xCenter > x2 && yCenter > y2) {
            return (xCenter - x2) * (xCenter - x2) + (yCenter - y2) * (yCenter - y2) <= radius * radius;
        }
        // 右下方
        if (xCenter > x2 && yCenter < y1) {
            return (xCenter - x2) * (xCenter - x2) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius;
        }              
        return false;
    }
}
// @lc code=end

