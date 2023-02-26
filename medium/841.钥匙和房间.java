import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int num : rooms.get(cur)) {
                    if (!set.contains(num)) {
                        queue.offer(num);
                        set.add(num);
                    }
                }
            }
        }
        return set.size() == rooms.size();
    }
}
// @lc code=end

