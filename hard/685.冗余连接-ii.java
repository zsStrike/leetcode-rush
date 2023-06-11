import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=685 lang=java
 *
 * [685] 冗余连接 II
 */

// @lc code=start
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        for (int i = n - 1; i >= 0; i--) {
            if (helper(edges, i)) return edges[i];
        }
        return null;
    }
    boolean helper(int[][] edges, int notChose) {
        int n = edges.length;
        int[] ind = new int[n + 1];
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (i == notChose) continue;
            int a = edges[i][0], b = edges[i][1];
            ind[b]++;
            adj[a].add(b);
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) {
                if (root != -1) return false;
                root = i;
            }
        }
        if (root == -1) return false;
        // System.out.println("root:" + root);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // System.out.println(cur);
                // System.out.println(adj[cur]);
                for (int neibo : adj[cur]) {
                    if (visited.contains(neibo)) return false;
                    // System.out.println("neibo" + neibo);
                    queue.offer(neibo);
                    visited.add(neibo);
                }
            }
        }
        return visited.size() == n;
    }
}

// @lc code=end

