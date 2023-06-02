import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=2248 lang=java
 *
 * [2248] 多个数组求交集
 */

// @lc code=start
class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums) {
            for (int n : num) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        return map.entrySet().stream().filter(entry -> entry.getValue() == nums.length)
                .map(et -> et.getKey()).sorted()
                .collect(Collectors.toList());
    }
}
// @lc code=end

