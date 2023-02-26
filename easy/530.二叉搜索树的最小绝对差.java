/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    public int getMinimumDifference(TreeNode root) {
        int min = MAX;
        if (root.left != null) {
            min = Math.min(min, getMinimumDifference(root.left));
            min = Math.min(min, root.val - getPrecessor(root));
        }
        if (root.right != null) {
            min = Math.min(min, getMinimumDifference(root.right));
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

