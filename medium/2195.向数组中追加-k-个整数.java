import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2195 lang=java
 *
 * [2195] 向数组中追加 K 个整数
 */

// @lc code=start
class Solution {
    public long minimalKSum(int[] nums, int k) {
        nums = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(nums);
        if (k < nums[0]) return (1L + k) * k / 2;
        int pre = 0;
        int i = 0;
        while (i < nums.length) {
            if (pre + k >= nums[i]) {
                k -= nums[i] - pre - 1;
                pre = nums[i];
                i++;
            } else {
                break;
            }
        }
        i--;
        long sum = (1L + (nums[i] + k)) * ((nums[i] + k)) / 2;
        while (i >= 0) {
            sum -= nums[i];
            i--;
        }
        return sum;
    }
}
// @lc code=end

