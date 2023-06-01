package contest;
import java.util.*;

public class Contest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString("/a/b".substring(1).split("/")));
        // System.out.println(sol.makeIntegerBeautiful(4545454545L, 15)); 
    }
    public static int[] parseArr(String arrStr) {
        // arrStr = [1, 2, 3, 4]
        arrStr = arrStr.substring(1, arrStr.length() - 1);
        String[] data = arrStr.split(",\\s?");
        return Arrays.stream(data).mapToInt(a -> Integer.parseInt(a)).toArray();
    }
}



class Solution {
    // 唯一路径，找到路径中涉及到的点
    // 在所有点中，求解问题
    HashMap<String, Integer> memo;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }    
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int[] trip : trips) {
            HashSet<Integer> path = new HashSet<>();
            path.add(trip[0]);
            findPath(trip[0], trip[1], adj, path);
            for (int key : path) {
                count.put(key, count.getOrDefault(key, 0) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : count.keySet()) {
            list.add(key);
        }
        memo = new HashMap<>();
        return dfs(0, list, count, price, adj, new HashSet<>());

    }

    // 表示从 idx 到结束最小的结果
    int dfs(int idx, ArrayList<Integer> list, HashMap<Integer, Integer> count, int[] price, ArrayList<Integer>[] adj, HashSet<Integer> half) {
        if (idx == list.size()) {
            int total = 0;
            for (int key : count.keySet()) {
                total += price[key] * count.get(key);
            }
            return total;
        }
        int cur = list.get(idx);
        boolean canHalf = true;
        for (int neibor : adj[cur]) {
            if (half.contains(neibor)) {
                canHalf = false;
                break;
            }
        }
        String memoKey = idx + " " + half.toString();
        if (memo.containsKey(memoKey)) return memo.get(memoKey); 
        int ans = Integer.MAX_VALUE;       
        if (canHalf) {
            half.add(cur);
            price[cur] /= 2;
            ans = Math.min(dfs(idx + 1, list, count, price, adj, half), ans);
            price[cur] *= 2;
            half.remove(cur);
        }
        ans = Math.min(dfs(idx + 1, list, count, price, adj, half), ans);
        memo.put(memoKey, ans);
        return ans;       
    }
    

    boolean findPath(int cur, int target, ArrayList<Integer>[] adj, HashSet<Integer> visited) {
        if (cur == target) {
            return true;
        }
        for (int next : adj[cur]) {
            if (visited.contains(next)) {
                continue;
            }
            visited.add(next);
            if (findPath(next, target, adj, visited)) {
                return true;
            }
            visited.remove(next);
        }
        return false;
    }
    
}



