import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (sum % k == 0 && i >= 1) {
                return true;
            }
            if (map.containsKey(sum % k)) {
                if (i - map.get(sum % k) >= 2) {
                    return true;
                }
            } else {
                map.put(sum % k, i);
            }
        }
        return false;
    }
}
// @lc code=end

