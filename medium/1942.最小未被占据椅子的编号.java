import java.util.PriorityQueue;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=1942 lang=java
 *
 * [1942] 最小未被占据椅子的编号
 */

// @lc code=start
class Solution {
    class Item {
        int id;
        int arrive;
        int leave;
        int seat;
        Item (int id, int arrive, int leave) {
            this.id = id;
            this.arrive = arrive;
            this.leave = leave;
            this.seat = -1;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Item> items = new PriorityQueue<>((a, b) -> a.arrive - b.arrive);
        PriorityQueue<Item> inpos = new PriorityQueue<>((a, b) -> a.leave - b.leave);
        TreeSet<Integer> seats = new TreeSet<>();
        for (int i = 0; i < times.length; i++) {
            seats.add(i);
            items.offer(new Item(i, times[i][0], times[i][1]));
        }
        while (!items.isEmpty()) {
            Item item = items.poll();
            while (!inpos.isEmpty() && item.arrive >= inpos.peek().leave) {
                Item gone = inpos.poll();
                seats.add(gone.seat);
            }
            int curSeat = seats.iterator().next();
            seats.remove(curSeat);
            item.seat = curSeat;
            if (item.id == targetFriend) {
                return curSeat;
            }
            inpos.offer(item);
        }
        return -1;
    }
}
// @lc code=end

