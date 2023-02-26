/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树节点最小距离
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
    int MIN = -1000000;
    int MAX = 1000000;
    public int minDiffInBST(TreeNode root) {
        int min = MAX;
        if (root.left != null) {
            min = Math.min(min, minDiffInBST(root.left));
            min = Math.min(min, root.val - getPrecessor(root));
        }
        if (root.right != null) {
            min = Math.min(min, minDiffInBST(root.right));
            min = Math.min(min, getSuccessor(root) - root.val);
        }
        return min;
    }
    int getPrecessor(TreeNode root) {
        if (root.left == null) {
            return MIN;
        }
        TreeNode pre = root.left;
        TreeNode next = pre.right;
        while (next != null) {
            pre = next;
            next = next.right;
        }
        return pre.val;
    }
    int getSuccessor(TreeNode root) {
        if (root.right == null) {
            return MAX;
        }
        TreeNode pre = root.right;
        TreeNode next = pre.left;
        while (next != null) {
            pre = next;
            next = next.left;
        }
        return pre.val;
    }
}
// @lc code=end

