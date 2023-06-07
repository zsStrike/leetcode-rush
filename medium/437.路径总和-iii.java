import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        traverse(root, targetSum, 0L, map);
        return ans;
    }
    void traverse(TreeNode root, int target, long preSum, HashMap<Long, Integer> map) {
        if (root == null) return;
        preSum += root.val;
        ans += map.getOrDefault(preSum - target, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        traverse(root.left, target, preSum, map);
        traverse(root.right, target, preSum, map);
        map.put(preSum, map.get(preSum) - 1);
    }
}
// @lc code=end

