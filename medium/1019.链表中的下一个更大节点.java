import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            ListNode node = head.next;
            while (node != null && node.val <= head.val) {
                node = node.next;
            }
            if (node == null) {
                list.add(0);
            } else {
                list.add(node.val);
            }
            head = head.next;
        }
        return list.stream().mapToInt(a -> a.intValue()).toArray();
    }
}
// @lc code=end

