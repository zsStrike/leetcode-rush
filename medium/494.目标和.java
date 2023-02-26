import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    // 原来总和是 sum ，添加负号  sum - 2x = target
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum - target) % 2 != 0) {
            return 0;
        }
        return dfs(nums, target, 0, 0);
    }
    private int dfs(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        int count = 0;
        // System.out.println(sum + nums[idx]);
        // System.out.println(target);
        count += dfs(nums, target, idx + 1, sum + nums[idx]);
        // for (int i = 0; i < idx; i++) {
        //     System.out.print(" ");
        // }
        // System.out.println(idx + " " + count);
        count += dfs(nums, target, idx + 1, sum - nums[idx]);
        // for (int i = 0; i < idx; i++) {
        //     System.out.print(" ");
        // }        
        // System.out.println(idx + " " + count);
        return count;
    }
}
// @lc code=end

