import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1238 lang=java
 *
 * [1238] 循环码排列
 */

// @lc code=start
class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public List<Integer> circularPermutation(int n, int start) {
        LinkedList<Integer> ans = new LinkedList<>();
        ans.addLast(start);
        visited.add(start);
        dfs(n, start, ans);
        return ans;
    }
    boolean dfs(int n, int cur, LinkedList<Integer> list) {
        // System.out.println(cur + " " + list);
        if (list.size() == (1 << n)) {
            int tmp = list.getFirst() ^ list.getLast();
            if ((tmp & (tmp - 1)) == 0) {
                return true;
            }
            return false;
        }
        int mask = 1;
        for (int i = 0; i < n; i++) {
            int next = cur ^ mask;
            if (visited.contains(next)) {
                mask <<= 1;
                continue;
            }
            list.addLast(next);
            visited.add(next);
            if (dfs(n, next, list)) {
                // System.out.println(list);
                return true;
            }
            list.removeLast();
            visited.remove(next);
            mask <<= 1;
        }
        return false;
    }
}
// @lc code=end

