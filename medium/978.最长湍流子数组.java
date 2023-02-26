import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=978 lang=java
 *
 * [978] 最长湍流子数组
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        }
        if (len == 2) {
            return arr[0] == arr[1] ? 1 : len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[i - 1]) {
                dp[i] = 2;
            }
        }
        for (int i = 2; i < len; i++) {
            if (arr[i] > arr[i - 1] && arr[i - 1] < arr[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else if (arr[i] < arr[i - 1] && arr[i - 1] > arr[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

