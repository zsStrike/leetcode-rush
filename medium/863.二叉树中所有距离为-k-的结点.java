import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        travese(root, parent);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int count = 0;
        while (!queue.isEmpty()) {
            if (count == k) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }
                if (parent.containsKey(node) && !visited.contains(parent.get(node))) {
                    queue.offer(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
            count++;
        } 
        return queue.stream().mapToInt(a -> a.val).boxed().collect(Collectors.toList());
    }
    void travese(TreeNode root, HashMap<TreeNode, TreeNode> p) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            p.put(root.left, root);
            travese(root.left, p);
        }
        if (root.right != null) {
            p.put(root.right, root);
            travese(root.right, p);
        }
    }
}
// @lc code=end

