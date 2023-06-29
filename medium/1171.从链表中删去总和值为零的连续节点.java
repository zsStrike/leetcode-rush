/*
 * @lc app=leetcode.cn id=1171 lang=java
 *
 * [1171] 从链表中删去总和值为零的连续节点
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * [1, 2, 3, -3, 4]
 * 1 1
 * 3 2
 * 6 3
 * 3 
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        HashMap<Integer, ListNode> map = new HashMap<>();
        int preSum = 0;
        map.put(preSum, dummyHead);
        ListNode pre = dummyHead, cur = dummyHead.next;
        while (cur != null) {
            preSum += cur.val;
            if (map.containsKey(preSum)) {
                map.get(preSum).next = cur.next;
                return removeZeroSumSublists(dummyHead.next);
            } else {
                map.put(preSum, cur);
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
// @lc code=end

