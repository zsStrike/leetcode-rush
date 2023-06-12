import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]) == 0 ?
                                        Integer.compare(a[0], b[0]) :
                                        Integer.compare(a[1], b[1]));
        int count = 0;
        int cur = 0, n = points.length;
        while (cur < n) {
            int end = points[cur][1];
            while (cur < n && points[cur][0] <= end) {
                cur++;
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

