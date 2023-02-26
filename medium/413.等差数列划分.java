/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int first = 0, n = nums.length;
        int second;
        int cur;
        int sum = 0;
        while (first < n) {
            second = first + 1;
            cur = second + 1;
            while (cur < n && nums[second] - nums[first] == nums[cur] - nums[cur - 1]) {
                cur++;
            }
            
            // System.out.println(first + " " + cur);
            sum += count(cur - first);
            first = cur - 1;
        }
        return sum;
    }
    int count(int n) {
        // n = 3 1
        // n = 4 1 + 2
        // n = 5 1 + 2 + 3
        // n  (1 + n - 2) * (n - 2) / 2
        if (n < 3) {
            return 0;
        }
        return (1 + n - 2) * (n - 2) / 2;
    }
}
// @lc code=end

