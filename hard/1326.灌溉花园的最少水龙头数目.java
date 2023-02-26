import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=1326 lang=java
 *
 * [1326] 灌溉花园的最少水龙头数目
 */

// @lc code=start
class Solution {
    public int minTaps(int n, int[] ranges) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i <= n; i++) {
            int left = i - ranges[i];
            int right = i + ranges[i];
            map.put(left, right);
        }
        int ans = 0;
        int cur = 0;
        // System.out.println(map.toString());
        while (cur < n) {
            Integer key = map.floorKey(cur);
            int max = cur;
            System.out.println("cur = " + cur);
            while (key != null) {
                if (map.get(key) >= cur) {
                    // System.out.println(key + " " + map.get(key));
                    max = Math.max(max, map.get(key));
                }
                key = map.lowerKey(key);
            }
            // System.out.println("=======");
            if (max == cur) {
                return -1;
            }
            cur = max;
            ans++;
        }
        return ans;
    }
}
// @lc code=end

