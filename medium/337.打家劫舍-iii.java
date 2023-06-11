import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (memo.containsKey(root)) return memo.get(root);
        if (root == null) return 0;
        int max = root.val + 
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + 
                (root.right == null ? 0 : rob(root.right.right) + rob(root.right.left));
        max = Math.max(max, rob(root.left) + rob(root.right));
        memo.put(root, max);
        return max;
    }
}
// @lc code=end

