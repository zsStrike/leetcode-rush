/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int pos = 0;
        double sum = 0;
        int size = 0;
        while (pos < k) {
            sum += nums[pos];
            size++;
            pos++;
        }
        double max = Integer.MIN_VALUE;
        while (pos < len) {
            max = Math.max(max, sum * 1.0 / size);
            System.out.println(max);
            sum -= nums[pos - k];
            sum += nums[pos];
            pos++;
            
        }
        System.out.println(sum + " " + size + " " + max);
        max = Math.max(max, sum / size);
        return max;
    }
}
// @lc code=end

