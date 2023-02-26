import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        LinkedList<Integer> ans = new LinkedList<>();
        int num = 1;
        for (int i = 1; i <= n; i++) {
            ans.add(num);
            if (num * 10 <= n) {
                num = num * 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return ans;
    }
}
// @lc code=end

