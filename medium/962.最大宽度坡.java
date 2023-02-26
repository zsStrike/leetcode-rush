import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=962 lang=java
 *
 * [962] 最大宽度坡
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    dp[i] = i - j;
                    break;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

