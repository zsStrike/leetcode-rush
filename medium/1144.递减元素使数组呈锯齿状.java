/*
 * @lc app=leetcode.cn id=1144 lang=java
 *
 * [1144] 递减元素使数组呈锯齿状
 */
import java.util.*;

// @lc code=start
class Solution {
    // 9,6,1,6,2
    // 9 6 7 6 7
    // 5 6 1 6 2
    // dp[i][0] 表示 i 结尾，最后升序
    // dp[i][1] 表示 i 结尾，最后降序
    // dp[j][0] = dp[j - 1][1] + num[j - 1][1] < A[j] ? 0 : A[j] - num[j - 1][1] + 1;
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        for (int i = 0; i < n; i += 2) {
            int min = 2000;
            if (i > 0) min = Math.min(min, nums[i - 1]);
            if (i < n - 1) min = Math.min(min, nums[i + 1]); 
            sum1 += nums[i] < min ? 0 : nums[i] - min + 1;
        }
        int sum2 = 0;
        for (int i = 1; i < n; i += 2) {
            int min = 2000;
            if (i > 0) min = Math.min(min, nums[i - 1]);
            if (i < n - 1) min = Math.min(min, nums[i + 1]); 
            sum2 += nums[i] < min ? 0 : nums[i] - min + 1;
        } 
        return Math.min(sum1, sum2);
        
    }
}
// class Solution {
//     // 9,6,1,6,2
//     // 9 6 7 6 7
//     // 5 6 1 6 2
//     // dp[i][0] 表示 i 结尾，最后升序
//     // dp[i][1] 表示 i 结尾，最后降序
//     // dp[j][0] = dp[j - 1][1] + num[j - 1][1] < A[j] ? 0 : A[j] - num[j - 1][1] + 1;
//     public int movesToMakeZigzag(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][2];
//         int last0 = nums[0], last1 = nums[0];
//         dp[0][0] = dp[0][1] = 0;
//         for (int i = 1; i < n; i++) {
//             // System.out.println("last0=" + last0 + " last1=" + last1);
//             dp[i][0] = dp[i - 1][1] + (last1 < nums[i] ? 0 : last1 - nums[i] + 1);
//             dp[i][1] = dp[i - 1][0] + (last0 > nums[i] ? 0 : nums[i] - last0 + 1);
//             int next1 = last0 > nums[i] ? nums[i] : last0 - 1;
//             int next0 = last1 < nums[i] ? nums[i] : last1 + 1;
//             last0 = next0;
//             last1 = next1;
//         }
//         // System.out.println(Arrays.deepToString(dp));
//         return Math.min(dp[n - 1][0], dp[n - 1][1]);
//     }
// }
// @lc code=end

