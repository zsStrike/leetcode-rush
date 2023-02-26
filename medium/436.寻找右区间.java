import java.util.ArrayList;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            map.put(interval[0], new int[] {interval[1], i});
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] inter : intervals) {
            Integer key = map.ceilingKey(inter[1]);
            if (key == null) {
                list.add(null);
            } else {
                list.add(map.get(key)[1]);
            }
        }
        // System.out.println(list);
        return list.stream().mapToInt(a -> a == null ? -1 : a).toArray();
    }
}
// @lc code=end

