import java.util.HashMap;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=865 lang=java
 *
 * [865] 具有所有最深节点的最小子树
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        travese(root, parent);
        HashSet<TreeNode> cur = new HashSet<>();
        cur.add(root);
        while (true) {
            HashSet<TreeNode> next = new HashSet<>();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            if (next.isEmpty()) {
                break;
            }
            cur = next;
        }
        while (cur.size() > 1) {
            HashSet<TreeNode> next = new HashSet<>();
            for (TreeNode node : cur) {
                next.add(parent.get(node));
            }
            cur = next;
        }
        return cur.iterator().next();
    }
    void travese(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
            travese(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right, root);
            travese(root.right, map);
        }        
    }
}
// @lc code=end

