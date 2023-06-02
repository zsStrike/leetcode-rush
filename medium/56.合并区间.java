import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int end = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && end >= intervals[j][0]) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            list.add(new int[] {intervals[i][0], end});
            i = j;
        }
        int[][] ans = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
// @lc code=end

