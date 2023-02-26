import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int count = 0;
        int max = 1;
        while (head != null) {
            while (head != null && !set.contains(head.val)) {
                head = head.next;
            }
            // System.out.println(head.val);
            if (head != null) {
                count++;
            }
            while (head != null && set.contains(head.val)) {
                head = head.next;
            } 
        }
        return count;
    }
}
// @lc code=end

