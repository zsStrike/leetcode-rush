import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // int[0] 数字 int[1] 次数
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int key : map.keySet()) {
            queue.offer(new int[]{key, map.get(key)});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().mapToInt(a -> a[0]).toArray();
    }
}
// @lc code=end

