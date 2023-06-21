/*
 * @lc app=leetcode.cn id=1721 lang=java
 *
 * [1721] 交换链表中的节点
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);

        int len = 0;
        ListNode cur = dummyHead;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int nk = len - k;
        ListNode knode = getKNode(head, k);
        ListNode nknode = getKNode(head, nk);
        int tmp = knode.val;
        knode.val = nknode.val;
        nknode.val = tmp;
        return head;
    }
    ListNode getKNode(ListNode head, int k) {
        while (k > 1) {
            k--;
            head = head.next;
        }
        return head;
    }
}
// @lc code=end

