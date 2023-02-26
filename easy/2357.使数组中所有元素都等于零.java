import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=2357 lang=java
 *
 * [2357] 使数组中所有元素都等于零
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums).filter(a -> a > 0).mapToObj(a -> Integer.valueOf(a)).collect(Collectors.toSet()).size();
    }
}
// @lc code=end

