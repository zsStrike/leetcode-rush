import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=894 lang=java
 *
 * [894] 所有可能的真二叉树
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
    public List<TreeNode> allPossibleFBT(int n) {
        // n = 1 [0]
        // n = 2 null
        // n = 3 [0, 0, 0]
        // n = 4 []
        // n = 5 [0, 0, 0, 0, 0, null. null] [0, 0, 0, null, null, 0, 0]
        // n = 7 
        // n = 9 
        // 从 n = 7 子树中找到任意一个叶子结点，添加两个子节点即可
        // 从 n = 5 子树中找到任意 2 个叶子结点，添加 4 个子节点即可
        LinkedList<TreeNode> ans = new LinkedList<>();
        if (n % 2 == 0) {
            return ans;
        }
        TreeNode root = new TreeNode(0);
        if (n == 1) {
            ans.add(root);
            return ans;
        }
        for (int i = 1; i < n - 1; i++) {
            // 左边 i 个节点
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(n - 1 - i);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    root.left = left;
                    root.right = right;
                    ans.add(copy(root));
                }
            }
        }
        return ans;
        // LinkedList<TreeNode> ans = new LinkedList<>();
        // if (n % 2 == 0) {
        //     return ans;
        // }
        // LinkedList<TreeNode> list = new LinkedList<>();
        // TreeNode root = new TreeNode(0);
        // list.add(root);
        // dfs(n - 1, list, ans, root);
        // return ans;
    }
    void dfs(int n, LinkedList<TreeNode> list, LinkedList<TreeNode> ans, TreeNode root) {
        if (n == 0) {
            ans.add(copy(root));
            return;
        }
        LinkedList<TreeNode> next = new LinkedList<>(list);
        for (TreeNode node : list) {
            node.left = new TreeNode(0);
            node.right = new TreeNode(0);
            next.remove(node);
            next.add(node.left);
            next.add(node.right);
            dfs(n - 2, next, ans, root);
            next.add(node);
            next.remove(node.left);
            next.remove(node.right);
            node.left = null;
            node.right = null;
        }
    }
    TreeNode copy(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode copy = new TreeNode(0);
        copy.left = copy(root.left);
        copy.right = copy(root.right);
        return copy;
    }
}
// @lc code=end

