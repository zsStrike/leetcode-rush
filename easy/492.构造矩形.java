/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int l = 0, w = 0;
        int maxl = (int)Math.ceil(Math.sqrt(area));
        for (l = maxl; l <= area; l++) {
            if (area % l == 0) {
                return new int[] {l, area / l};
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

