/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start
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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = head.next;
        ListNode cur = head.next.next;
        int idx = 3;
        while (cur != null) {
            if (idx % 2 == 0) {
                even.next = cur;
                even = cur;
            } else {
                odd.next = cur;
                odd = cur;
            }
            cur = cur.next;
            idx++;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}
// @lc code=end

