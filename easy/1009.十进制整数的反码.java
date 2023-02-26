import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        Deque<Integer> queue = new LinkedList<>();
        while (n != 0) {
            queue.offerLast(1 - (n % 2));
            n /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pollLast());
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
// @lc code=end

