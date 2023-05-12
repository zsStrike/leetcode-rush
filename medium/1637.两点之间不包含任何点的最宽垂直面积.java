import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1637 lang=java
 *
 * [1637] 两点之间不包含任何点的最宽垂直面积
 */

// @lc code=start
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        // System.out.println(Arrays.deepToString(points));
        int n = points.length;
        int max = 0;
        int pre = points[0][0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, points[i][0] - pre);
            pre = points[i][0];
        }
        return max;
    }
}
// @lc code=end

