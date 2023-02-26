import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=757 lang=java
 *
 * [757] 设置交集大小至少为2
 */

// @lc code=start
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int n = intervals.length;
        //初始的两个元素
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        //从后向前遍历
        for (int i = n - 2; i >= 0; i--) {
            //开始分类讨论
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
            } else {
                next = cur;
                cur = intervals[i][0];
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

