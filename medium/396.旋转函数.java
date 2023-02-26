import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        int[] delta = new int[n];
        // delta[0] = sum - n * nums[n - 1];
        for (int i = 0; i < n; i++) {
            delta[0] += i * nums[i];
        }
        for (int i = 1; i < n; i++) {
            delta[i] = sum - n * nums[n - i];
        }
        // System.out.println(Arrays.toString(delta));
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += delta[i];
            max = Math.max(max, tmp);
        }
        return max;
    }
}
// @lc code=end

