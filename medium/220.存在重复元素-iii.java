import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] arr, int k, int t) {
        long[] nums = Arrays.stream(arr).mapToLong(a -> a).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i > k) {
                    break;
                }
                if (Math.abs(nums[j] - nums[i]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

