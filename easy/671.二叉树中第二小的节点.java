import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
    HashSet<Integer> set = new HashSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        List<Integer> list = set.stream().collect(Collectors.toList());
        System.out.println(list);
        if (list.size() == 1) {
            return -1;
        }
        Collections.sort(list); 
        return list.get(1);
    }
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            set.add(root.val);
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end

