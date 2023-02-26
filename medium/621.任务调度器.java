import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javafx.scene.layout.Priority;

/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    class Node {
        char task;
        int n;
        Node(char task, int n) {
            this.task = task;
            this.n = n;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.n - a.n);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1); 
        }
        for (char key : map.keySet()) {
            queue.offer(new Node(key, map.get(key)));   
        }
        System.out.println(queue);
        int time = 0;
        while (!queue.isEmpty()) {
            int nt = 0;
            LinkedList<Node> list = new LinkedList<>();
            while (nt <= n && !queue.isEmpty()) {
                Node node = queue.poll();
                // System.out.println(nt + " " + node.task + " " + node.n);
                if (node.n > 1) {
                    list.add(node);
                }
                nt++;
            }
            if (queue.isEmpty() && list.isEmpty()) {
                time += nt;
            } else {
                time += (n + 1);
            }
            // System.out.println(list.size());
            for (Node node : list) {
                // System.out.println(node.task);
                node.n--;
                queue.offer(node);
            }
        }
        return time;
    }
}
// @lc code=end

