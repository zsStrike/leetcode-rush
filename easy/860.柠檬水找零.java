import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                if (map.getOrDefault(5, 0) == 0) {
                    return false;
                }
                map.put(5, map.get(5) - 1);
                map.put(10, map.getOrDefault(10, 0) + 1);
            } else {
                if (map.getOrDefault(10, 0) > 0 && map.getOrDefault(5, 0) > 0) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                    map.put(20, map.getOrDefault(20, 0) + 1);
                } else if (map.getOrDefault(5, 0) > 2) {
                    map.put(5, map.get(5) - 3);
                    map.put(20, map.getOrDefault(20, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

