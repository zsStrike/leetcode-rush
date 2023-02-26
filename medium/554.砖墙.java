import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=554 lang=java
 *
 * [554] 砖墙
 */

// @lc code=start
class Solution {
    // 1 2 2 2 2 1
    // 3 3 3 1 2 2
    // 1 3 3 3 2 2
    // 2 2 4 4 4 4
    // 3 3 3 1 2 2
    // 1 3 3 3 1 1
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = wall.size();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int num : list) {
                sum += num;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum);
        }
        int max = 0;
        for (int key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
            }
        }
        return n - max;
    }
}
// @lc code=end

