import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1129 lang=java
 *
 * [1129] 颜色交替的最短路径
 */

// @lc code=start
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, HashSet<Integer>> redMap = getMap(redEdges);
        HashMap<Integer, HashSet<Integer>> blueMap = getMap(blueEdges);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, -1}); // -1 初始颜色，0 是红色，1是蓝色
        HashSet<String> visited = new HashSet<>();
        // visited.add();
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] data = queue.poll();
                System.out.println(count + " " + data[0]);
                if (ans[data[0]] == -1 || ans[data[0]] > count) {
                    ans[data[0]] = count;
                }
                if ((data[1] == -1 || data[1] == 0) && blueMap.containsKey(data[0])) {
                    for (int next : blueMap.get(data[0])) {
                        String key = genKey(data[0], next, 1);
                        if (!visited.contains(key)) {
                            queue.offer(new int[] {next, 1});
                            visited.add(key);
                        }
                    }
                }
                if ((data[1] == -1 || data[1] == 1) && redMap.containsKey(data[0])) {
                    for (int next : redMap.get(data[0])) {
                        String key = genKey(data[0], next, 0);
                        if (!visited.contains(key)) {
                            queue.offer(new int[] {next, 0});
                            visited.add(key);
                        }
                    }
                }
            }
            count++;
        }
        return ans;
    }

    HashMap<Integer, HashSet<Integer>> getMap(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
        }
        return map;
    }
    String genKey(int start, int end, int color) {
        return start + "," + end + "," + color;
    }
}
// @lc code=end

