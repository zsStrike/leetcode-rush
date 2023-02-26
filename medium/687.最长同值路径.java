/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = maxSame(root.left, root.val) + maxSame(root.right, root.val);
        return Math.max(Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)), max);
    }
    int maxSame(TreeNode root, int target) {
        if (root == null || root.val != target) {
            return 0;
        }
        return Math.max(maxSame(root.left, target), maxSame(root.right, target)) + 1;
    }
}
// @lc code=end

