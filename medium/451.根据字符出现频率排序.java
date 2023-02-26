import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

import javafx.scene.layout.Priority;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (queue.isEmpty() == false) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = entry.getValue(); i > 0; i--) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
// @lc code=end

