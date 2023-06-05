import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int j = cols - 1; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                matrix[i][j] -= '0';
                if (matrix[i][j] == 1 && j < cols - 1) {
                    matrix[i][j] += matrix[i][j + 1];
                }
            }
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int j = cols - 1; j >= 0; j--) {
            stack.clear();
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && matrix[stack.peek()][j] >= matrix[i][j]) {
                    int idx = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    max = Math.max(max, (i - left - 1) * matrix[idx][j]);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int idx = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (rows - left - 1) * matrix[idx][j]);
            }
        }
        return max;
    }
}
// @lc code=end

