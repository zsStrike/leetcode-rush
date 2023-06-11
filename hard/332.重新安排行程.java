import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, TreeMap<String, Integer>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from, new TreeMap<>());
            TreeMap<String, Integer> map = adj.get(from);
            map.put(to, map.getOrDefault(to, 0) + 1);
        }
        LinkedList<String> ans = new LinkedList<>();
        ans.add("JFK");
        dfs("JFK", adj, tickets.size(), ans);
        return ans;
    }
    boolean dfs(String cur, HashMap<String, TreeMap<String, Integer>> adj, int left, LinkedList<String> ans) {
        // System.out.println(left + " " + ans);
        if (left == 0) {
            return true;
        }
        if (adj.get(cur) == null) return false;
        for (String neibo : adj.get(cur).keySet()) {
            int count = adj.get(cur).get(neibo);
            if (count == 0) continue;
            adj.get(cur).put(neibo, count - 1);
            ans.addLast(neibo);
            if (dfs(neibo, adj, left - 1, ans)) {
                return true;
            }
            adj.get(cur).put(neibo, count);
            ans.removeLast();
        }
        return false;
    }
}
// @lc code=end

