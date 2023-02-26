import java.util.HashMap;
import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            last.put(nums[i], i);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                min = Math.min(min, last.get(key) - first.get(key) + 1);
            } else if (map.get(key) > max) {
                min = last.get(key) - first.get(key) + 1;
                max = map.get(key);
            }
        }
        return min;
    }
}
// @lc code=end

