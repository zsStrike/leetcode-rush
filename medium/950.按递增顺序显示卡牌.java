import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=950 lang=java
 *
 * [950] 按递增顺序显示卡牌
 */

// @lc code=start
class Solution {
    // [17, 13, 11, 2, 3, 5]
    // [2, 11, 3, 17, 5, 13] 11 17 13
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int len  = deck.length;
        for (int i = 0; i < len; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        System.out.println(list.toString());
        Arrays.sort(deck);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[list.get(i)] = deck[i];
        }
        return ans;
    }
}
// @lc code=end

