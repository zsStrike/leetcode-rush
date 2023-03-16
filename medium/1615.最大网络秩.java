import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1615 lang=java
 *
 * [1615] 最大网络秩
 */

// @lc code=start
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.putIfAbsent(road[0], new HashSet<>());
            map.putIfAbsent(road[1], new HashSet<>());
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        int max = 0;
        for (var entry1 : map.entrySet()) {
            for (var entry2 : map.entrySet()) {
                if (entry1.equals(entry2)) {
                    continue;
                }
                if (map.get(entry1.getKey()).contains(entry2.getKey())) {
                    max = Math.max(max, map.get(entry1.getKey()).size() + map.get(entry2.getKey()).size() - 1);
                } else {
                    max = Math.max(max, map.get(entry1.getKey()).size() + map.get(entry2.getKey()).size());
                }
            }
        }
        return max;
    }

}
// @lc code=end

