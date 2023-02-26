import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;
import javax.management.QueryEval;
import javax.print.attribute.standard.QueuedJobCount;

/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; sz--) {
                int u = queue.poll();
                for (int j = 0; j < graph[u].length; j++) {
                    int v = graph[u][j];
                    if (a.contains(u) && b.contains(v) || a.contains(v) && b.contains(u)) continue;
                    if (a.contains(u)) {
                        if (a.contains(v)) {
                            return false;
                        }
                        b.add(v);
                    } else if (b.contains(u)) {
                        if (b.contains(v)) {
                            return false;
                        }
                        a.add(v);
                    } else {
                        a.add(u);
                        b.add(v);
                    }
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.offer(v);
                    }
                }
            }
            System.out.println(queue);
            if (queue.size() == 0 && visited.size() < n) {
                for (int i = 0; i < n; i++) {
                    if (visited.contains(i)) continue;
                    queue.offer(i);
                    visited.add(i);
                    break;
                }
            }
        }
        return true;
    }
}
// @lc code=end

