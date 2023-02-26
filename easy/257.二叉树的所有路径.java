import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        traverse(root, new LinkedList());
        return ans;
    }
    void traverse(TreeNode root, LinkedList<String> sb) {
        sb.add("" + root.val);
        if (root.left == null && root.right == null) {
            ans.add(String.join("->", sb.toArray(new String[0])));
            // sb.deleteCharAt(sb.length() - 1);
            // return;
        }
        if (root.left != null) {
            traverse(root.left, sb);
        }
        if (root.right != null) {
            traverse(root.right, sb);
        }
        sb.removeLast();
    }
}
// @lc code=end

