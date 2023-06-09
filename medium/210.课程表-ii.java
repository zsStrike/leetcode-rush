import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indgree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            indgree[a]++;
            adj[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans.add(cur);
                for (int neibor : adj[cur]) {
                    indgree[neibor]--;
                    if (indgree[neibor] == 0) {
                        queue.offer(neibor);
                    }
                }
            }
        }
        if (ans.size() != numCourses) return new int[0];
        return ans.stream().mapToInt(a -> a).toArray();
    }
}
// @lc code=end

