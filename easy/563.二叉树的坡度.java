/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = findTilt(root.left);
        count += findTilt(root.right);
        count += Math.abs(count(root.left) - count(root.right));
        return count;
    }
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = root.val;
        count += count(root.left);
        count += count(root.right);
        return count;
    }
}
// @lc code=end

