import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=815 lang=java
 *
 * [815] 公交路线
 */

// @lc code=start
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        Set<Integer>[] sets = new HashSet[n];
        // 44
        for (int i = 0; i < n; i++) {
            sets[i] = Arrays.stream(routes[i]).boxed().collect(Collectors.toSet());
            // System.out.println(sets[i]);
        }
        // 双向 BFS
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        HashSet<Integer> visited1 = new HashSet<>();
        HashSet<Integer> visited2 = new HashSet<>();
        queue1.offer(source);
        visited1.add(source);
        queue2.offer(target);
        visited2.add(target);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Queue<Integer> queue = count % 2 == 0 ? queue1 : queue2;
            HashSet<Integer> visited = count % 2 == 0 ? visited1 : visited2;
            HashSet<Integer> otherVisisted = count % 2 == 0 ? visited2 : visited1;
            // System.out.println(queue);
            // System.out.println(visited);
            // System.out.println(otherVisisted);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // if (cur == target) return count;
                for (Set<Integer> set : sets) {
                    if (!set.contains(cur)) {
                        continue;
                    }
                    for (int next : set) {
                        if (visited.contains(next)) {
                            continue;
                        }
                        if (otherVisisted.contains(next)) return count + 1;
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
// @lc code=end

