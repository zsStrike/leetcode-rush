import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[n - 1][0] = 1;
        dp[n - 1][1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            int idx = -1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] != 0) {
                    continue;
                }
                if (max < 1 + dp[j][0]) {
                    max = 1 + dp[j][0];
                    idx = j;
                }
            }
            dp[i][0] = max;
            dp[i][1] = idx;
        }
        List<Integer> list = new LinkedList<>();
        int idx = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[i][0]) {
                max = dp[i][0];
                idx = i;
            }
        }
        while (idx != -1) {
            list.add(nums[idx]);
            idx = dp[idx][1];
        }
        return list;
    }
}
// @lc code=end

