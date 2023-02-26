/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        ListNode head = l1;
        l2 = reverseList(l2);
        ListNode pre = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            l1.val += l2.val + carry;
            carry = l1.val / 10;
            l1.val %= 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            pre.next = l2;
            l1 = l2;
        }
        while (l1 != null) {
           l1.val += carry;
           carry = l1.val / 10;
           l1.val %= 10;
           pre = l1;
           l1 = l1.next;            
        }
        if (carry == 1) {
            pre.next = new ListNode(carry);
        }
        return reverseList(head);
    }
    ListNode reverseList(ListNode list) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        ListNode node = list;
        ListNode next = node.next;
        while (node != null) {
            next = node.next;
            node.next = dummyHead.next;
            dummyHead.next = node;
            node = next;
        }
        // debug(dummyHead.next);
        return dummyHead.next;
    }
    void debug(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
// @lc code=end

