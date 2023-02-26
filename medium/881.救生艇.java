import java.util.Arrays;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int p : people) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        int count = 0;
        while (!map.isEmpty()) {
            int lastKey = map.lastKey();
            map.put(lastKey, map.get(lastKey) - 1);
            if (map.get(lastKey) == 0) {
                map.remove(lastKey);
            }
            if (map.floorKey(limit - lastKey) != null) {
                int second = map.floorKey(limit - lastKey);
                map.put(second, map.get(second) - 1);
                if (map.get(second) == 0) {
                    map.remove(second);
                }
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

