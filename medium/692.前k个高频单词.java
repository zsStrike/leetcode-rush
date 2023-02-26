import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            String[] as = a.split(" ");
            String[] bs = b.split(" ");
            if (Integer.parseInt(as[0]) != Integer.parseInt(bs[0])) {
                return Integer.parseInt(as[0]) - Integer.parseInt(bs[0]);
            }
            return bs[1].compareTo(as[1]);
        });
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String key : map.keySet()) {
            pq.offer(1000 + map.get(key) + " " + key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
        LinkedList<String> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.addFirst(pq.poll().split(" ")[1]);
        }
        return list;
    }
}
// @lc code=end

