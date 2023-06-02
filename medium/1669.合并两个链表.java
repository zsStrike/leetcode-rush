/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int idx = 0;
        ListNode pre = null, cur = list1;
        while (idx != a) {
            pre = cur;
            cur = cur.next;
            idx++;
        }
        pre.next = list2;
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (idx != b + 1) {
            pre = cur;
            cur = cur.next;
            idx++;
        }
        tail.next = cur;
        return list1;
    }
}
// @lc code=end

