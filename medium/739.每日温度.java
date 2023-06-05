import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] tp) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[tp.length];
        for (int i = tp.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && tp[deque.peek()] <= tp[i]) {
                deque.pop();
            }
            ans[i] = (deque.isEmpty() ? i : deque.peek()) - i;
            deque.push(i);
        }
        return ans;
    }
}
// @lc code=end

