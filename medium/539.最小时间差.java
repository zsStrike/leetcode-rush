import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String time : timePoints) {
            list.add(getMinutes(time));
        }
        int[] times = list.stream().mapToInt(a -> a).toArray();
        Arrays.sort(times);
        int n = times.length;
        System.out.println(Arrays.toString(times));
        int min = 24 * 60 - times[n - 1] + times[0];
        System.out.println(min);
        for (int i = 1; i < n; i++) {
            min = Math.min(min, times[i] - times[i - 1]);
        }
        return min;
    }
    int getMinutes(String time) {
        String[] ss = time.split(":");
        return 60 * Integer.parseInt(ss[0]) + Integer.parseInt(ss[1]);
    }
}
// @lc code=end

