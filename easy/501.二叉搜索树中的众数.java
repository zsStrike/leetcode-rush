import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        traverse(root);
        LinkedList<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (max == map.get(key)) {
                list.add(key);
            } else if (max < map.get(key)) {
                list.clear();
                list.add(key);
                max = map.get(key);
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end

