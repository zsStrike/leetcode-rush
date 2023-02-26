import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        LinkedList<Integer>[] adj = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(1);
        visited.add(1);
        dfs(1, visited, ans, adj);
        int idx = ans.indexOf(ans.getLast());
        HashSet<String> set = new HashSet<>();
        System.out.println(ans + " idx: " + idx);
        for (int i = idx; i < ans.size() - 1; i++) {
            set.add(ans.get(i) + " " + ans.get(i + 1));
            set.add(ans.get(i + 1) + " " + ans.get(i));
        }
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(edges[i][0] + " " + edges[i][1])) {
                return edges[i];
            }
        }
        return new int[] {-1, -1};
    }
    boolean dfs(int cur, HashSet<Integer> visited, LinkedList<Integer> list, LinkedList<Integer>[] adj) {
        for (int ad : adj[cur]) {
            int n = list.size();
            System.out.println(list + " " + ad);
            if (n >= 2 && list.get(n - 2) == ad) {
                continue;
            }
            if (visited.contains(ad)) {
                list.add(ad);
                return true;
            }
            visited.add(ad);
            list.add(ad);
            int index = list.size() - 1;
            System.out.println(list);
            if (dfs(ad, visited, list, adj)) {
                return true;
            }
            list.remove(index);
            visited.remove(ad);            
        }
        return false;
    }
    
}
// @lc code=end

