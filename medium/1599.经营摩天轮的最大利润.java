import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1599 lang=java
 *
 * [1599] 经营摩天轮的最大利润
 */

// @lc code=start
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int max = 0;
        int ans = -1;
        int curProfit = 0;
        int n = customers.length;
        int pre = 0;
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addAll(Arrays.asList(0, 0, 0, 0));
        for (int i = 0; i < n || pre > 0; i++) {
            pre += i < n ? customers[i] : 0;
            if (pre <= 4) {
                curProfit += pre * boardingCost - runningCost;
                pre = 0;
            } else {
                curProfit += 4 * boardingCost - runningCost;
                pre -= 4;
            }
            // System.out.println(curProfit);
            if (curProfit > max) {
                ans = i;
                max = curProfit;
            }
        }
        return max <= 0 ? -1 : ans + 1;
    }
}
// @lc code=end

