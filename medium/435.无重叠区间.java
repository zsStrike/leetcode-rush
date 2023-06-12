import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);
        int cur = 0, n = intervals.length;
        int count = 0;
        while (cur < n) {
            int end = intervals[cur][1];
            while (cur < n && intervals[cur][0] < end) {
                cur++;
            }
            count++;
        }
        return n - count;
    }
}
// @lc code=end

