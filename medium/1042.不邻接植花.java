import java.util.*;
/*
 * @lc app=leetcode.cn id=1042 lang=java
 *
 * [1042] 不邻接植花
 */

// @lc code=start
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Set<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<Integer>();
        }
        for (int[] path : paths) {
            int a = path[0] - 1, b = path[1] - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] color = new int[n];
        dfs(0, color, adj);
        return color;
    }
    boolean dfs(int idx, int[] color, Set<Integer>[] adj) {
        if (idx == color.length) {
            return true;
        }
        label:
        for (int i = 1; i <= 4; i++) {
            for (int next : adj[idx]) {
                if (color[next] == i) {
                    continue label;
                }
            }
            color[idx] = i;
            if (dfs(idx + 1, color, adj)) {
                return true;
            }
            color[idx] = 0;
        }
        return false;
    }
}
// @lc code=end

