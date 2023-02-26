import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Sink.ChainedInt;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = Arrays.stream(bank).collect(Collectors.toSet());
        if (!set.contains(end)) {
            return -1;
        }
        int tmp = dfs(start, end, set, new HashSet<>());
        return tmp == Integer.MAX_VALUE ? -1 : tmp;
    }
    int dfs(String cur, String end, Set<String> set, Set<String> visited) {
        if (cur.equals(end)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String s : set) {
            if (visited.contains(s)) {
                continue;
            }
            if (count(cur, s) != 1) {
                continue;
            }
            visited.add(s);
            int tmp = dfs(s, end, set, visited);
            if (tmp != Integer.MAX_VALUE) {
                min = Math.min(tmp + 1, min);
            }
            visited.remove(s);
        }
        return min;
    }
    int count(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

