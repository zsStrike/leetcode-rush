/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xnode = findNode(root, x);
        int leftCount = countSubtree(xnode.left);
        int rightCount = countSubtree(xnode.right);
        int rootCount = n - leftCount - rightCount - 1;
        if (leftCount + rightCount < rootCount ||
            leftCount + rootCount < rightCount ||
            rootCount + rightCount < leftCount) {
                return true;
        }
        return false;
    }
    TreeNode findNode(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return root;
        }
        TreeNode left = findNode(root.left, x);
        if (left != null) {
            return left;
        }
        return findNode(root.right, x);
    }
    int countSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countSubtree(root.left) + countSubtree(root.right);
    }
}
// @lc code=end

