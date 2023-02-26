import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
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
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        LinkedList<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                list.clear();
                list.add(key);
            } else if (map.get(key) == max) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
// @lc code=end

