import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
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
        int c;
        Node (TreeNode node, int c) {
            this.node = node;
            this.c = c;
        }
    }
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int m = height + 1, n = (int) (Math.pow(2, height + 1) - 1);
        // String[][] mat = new String[m][n];
        LinkedList<List<String>> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, (n - 1) / 2));
        int r = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add("");
            }
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.set(node.c, "" + node.node.val);
                if (node.node.left != null) {
                    queue.offer(new Node(node.node.left, node.c - (int)Math.pow(2, height - r - 1)));
                }
                if (node.node.right != null) {
                    queue.offer(new Node(node.node.right, node.c + (int)Math.pow(2, height - r - 1)));
                }
            }
            ans.add(list);
            r++;
        }
        return ans;
    }
    int height(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
// @lc code=end

