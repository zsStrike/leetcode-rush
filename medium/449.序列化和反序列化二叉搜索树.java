import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("#");
                } else {
                    sb.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                sb.append(",");
                size--;
            }
        }
        // 1 2 3 # # 4 # # #
        System.out.println(sb.toString());
        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("#")) {
            return null;
        }
        String[] ds = data.split(",");
        Queue<TreeNode> q1 = new LinkedList<>();
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(ds[idx]));
        q1.offer(root);
        idx++;
        while (q1.isEmpty() == false) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q1.poll();
                if (node != null) {
                    TreeNode left = ds[idx].equals("#") ? null : new TreeNode(Integer.parseInt(ds[idx]));
                    idx++;
                    TreeNode right = ds[idx].equals("#") ? null : new TreeNode(Integer.parseInt(ds[idx]));
                    idx++;
                    node.left = left;
                    node.right = right;
                    q1.offer(left);
                    q1.offer(right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end

