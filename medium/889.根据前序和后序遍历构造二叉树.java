/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }
    TreeNode constructFromPrePost(int[] pre, int[] post, int prei, int prej, int posti, int postj)  {
        if (prei > prej || posti > postj) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prei]);
        if (prei == prej) {
            return root;
        }
        int leftVal = pre[prei + 1];
        int idx = posti;
        for (idx = posti; idx <= postj; idx++) {
            if (post[idx] == leftVal) {
                break;
            }
        }
        int leftSize = idx - posti + 1;
        root.left = constructFromPrePost(pre, post, prei + 1, prei + leftSize, posti, idx);
        root.right = constructFromPrePost(pre, post, prei + leftSize + 1, prej, idx + 1, postj);
        return root;
    }
}
// @lc code=end

