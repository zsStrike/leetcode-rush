import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] sum = new int[1005];
        for (int[] trip : trips) {
            sum[trip[1]] += trip[0];
            sum[trip[2]] -= trip[0];
        }
        if (sum[0] > capacity) return false;
        for (int i = 1; i < 1005; i++) {
            sum[i] += sum[i - 1];
            if (sum[i] > capacity) {
                return false;
            }            
        }
        // System.out.println(Arrays.toString(sum));
        return true;
    }
}
// @lc code=end

