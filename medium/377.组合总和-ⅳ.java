import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return 1;
        }
        int sum = 0;
        for (int num : nums) {
            if (target - num >= 0) {
                sum += combinationSum4(nums, target - num);
            }
        }
        map.put(target, sum);
        return sum;
    }
}
// @lc code=end

