import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {

    TreeNode pointor;
    TreeNode root;
    Deque<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.pointor = null;
        this.queue = new LinkedList<>();
        TreeNode iter = root;
        while (iter != null) {
            queue.offerLast(iter);
            iter = iter.left;
        }
    }
    
    public int next() {
        TreeNode node = queue.pollLast();
        TreeNode iter = node.right;
        if (iter == null) {
            return node.val;
        }
        while (iter != null) {
            queue.offerLast(iter);
            iter = iter.left;
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

