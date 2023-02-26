import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=799 lang=java
 *
 * [799] 香槟塔
 */

// @lc code=start
class Solution {
    HashMap<String, Double> memo = new HashMap<>();
    public double champagneTower(int poured, int query_row, int query_glass) {
        double ans = helper(poured, query_row, query_glass);
        return ans > 1 ? 1 : ans;
    }
    double helper(int poured, int row, int glass) {
        String key = row + " " + glass;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // System.out.println(row + " " + glass);
        if (row == 0) {
            return poured;
        }
        double value = 0;
        if (glass == 0) {
            value = Math.max((helper(poured, row - 1, glass) - 1) / 2, 0);
        } else if (row == glass) {
            value = Math.max((helper(poured, row - 1, glass - 1) - 1) / 2, 0);
        } else {
            value = Math.max((helper(poured, row - 1, glass) - 1) / 2, 0) + Math.max((helper(poured, row - 1, glass - 1) - 1) / 2, 0);
        }
        memo.put(key, value);
        return value;
    }
}
// @lc code=end

