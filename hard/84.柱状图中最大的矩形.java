import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int idx = stack.pop();
                int left = stack.peek() == null ? -1 : stack.peek();
                max = Math.max(max, (i - left - 1) * heights[idx]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int left = stack.peek() == null ? -1 : stack.peek();
            max = Math.max(max, (n - left - 1) * heights[idx]);
        }
        return max;
    }
}
// @lc code=end

