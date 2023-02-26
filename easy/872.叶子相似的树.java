/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return traverse(root1).equals(traverse(root2));
    }
    String traverse(TreeNode root) {
        if (root == null) {
            return "";
        }
        String str = "";
        str += traverse(root.left);
        if (root.left == null && root.right == null) {
            str += " ";
            str += root.val;
            str += " ";
        }
        str += traverse(root.right);
        return str;
    }
}
// @lc code=end

