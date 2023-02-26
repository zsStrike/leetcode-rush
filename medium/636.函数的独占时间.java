import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
class Solution {
    // 4  1
    // 0s 0s 0e 0s 0e 0e
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        // Arrays.fill(res, -1);
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String log : logs) {
            String[] ls = log.split(":");
            if (ls[1].equals("start")) {
                deque.push(log);
            } else {
                String from = deque.pop();
                String[] a = from.split(":");
                int delta = Integer.parseInt(ls[2]) - Integer.parseInt(a[2]) + 1;
                res[Integer.parseInt(a[0])] += delta;
                if (!deque.isEmpty()) {
                    String[] b = deque.peek().split(":");
                    res[Integer.parseInt(b[0])] -= delta;   
                }    
        
            }
        }
        return res;
    }
}
// @lc code=end

