import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node {
        TreeNode node;
        long seq;
        Node (TreeNode node, long seq) {
            this.node = node;
            this.seq = seq;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(new Node(root, 1));
        long max = 0;
        while (!queue.isEmpty()) {
            long left = queue.peekFirst().seq;
            long right = queue.peekLast().seq;
            max = Math.max(max, right - left + 1);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node nd = queue.pollFirst();
                if (nd.node.left != null) {
                    queue.offerLast(new Node(nd.node.left, nd.seq * 2));
                }
                if (nd.node.right != null) {
                    queue.offerLast(new Node(nd.node.right, nd.seq * 2 + 1));
                }
            }
        }
        return (int) max;
    }
}
// @lc code=end

