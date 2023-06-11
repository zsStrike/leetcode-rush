import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new LinkedList<>());
        return list;
    }
    void dfs(TreeNode root, int targetSum, LinkedList<Integer> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (targetSum == root.val && ans.size() >= 0) {
                ans.add(root.val);
                list.add(new LinkedList<>(ans));
                ans.removeLast();
            }
            return;
        }
        ans.add(root.val);
        dfs(root.left, targetSum - root.val, ans);
        dfs(root.right, targetSum - root.val, ans);
        ans.removeLast();
    }
}
// @lc code=end

