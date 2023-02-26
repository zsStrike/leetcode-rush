import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=846 lang=java
 *
 * [846] 一手顺子
 */

// @lc code=start
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int cd : hand) {
            map.put(cd, map.getOrDefault(cd, 0) + 1);
        }
        while (!map.isEmpty()) {
            int key = map.firstKey();
            // System.out.println(map);
            for (int i = key; i < key + groupSize; i++) {
                // System.out.println(i);
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) - 1);
                    if (map.get(i) == 0) {
                        map.remove(i);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

