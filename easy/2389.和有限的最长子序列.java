import java.util.Arrays;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=2389 lang=java
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(nums);
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1]; 
            map.put(nums[i], i + 1);
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer lower = map.floorKey(queries[i]);
            if (lower == null) {
                ans[i] = 0;
            } else {
                ans[i] = map.get(lower);
            }
        }
        return ans;
    }
}
// @lc code=end

