import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=853 lang=java
 *
 * [853] 车队
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> p2s = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            p2s.put(position[i], speed[i]);
        }
        int count = 0;
        while (!p2s.isEmpty()) {
            // System.out.println(p2s);
            int pos = p2s.lastKey();
            int spd = p2s.get(pos);
            double hs = (target - pos) * 1.0 / spd;
            // System.out.println("hs=" + hs);
            p2s.remove(pos);
            while (p2s.lowerKey(pos) != null) {
                pos = p2s.lowerKey(pos);
                double hhs = (target - pos) * 1.0 / p2s.get(pos);
                // System.out.println("hhs=" + hhs);
                if (hhs > hs) {
                    break;
                }
                p2s.remove(pos);
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

