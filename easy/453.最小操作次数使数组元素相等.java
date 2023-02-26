import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }
}
// @lc code=end

