import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.bcel.internal.classfile.Node;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> map;
    boolean[] visited;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        visited = new boolean[102];
        map = new HashMap<>();
        Arrays.fill(visited, false);
        traverse(node);
        Arrays.fill(visited, false);
        addNeighbors(node);
        // System.out.println(map);
        // for (Node tmp : map.values()) {
        //     System.out.println(tmp.val + " " + tmp.neighbors);
        // }
        return map.get(node.val);
    }
    void addNeighbors(Node root) {
        if (root == null) {
            return;
        }
        if (visited[root.val]) {
            return;
        }
        visited[root.val] = true;
        Node node = map.get(root.val);
        for (Node tmp : root.neighbors) {
            node.neighbors.add(map.get(tmp.val));
        }
        for (Node tmp : root.neighbors) {
            addNeighbors(tmp);
        }        
    }
    void traverse(Node root) {
        // System.out.println(root + " " + root.val + " " + root.neighbors);
        if (root == null) {
            return;
        }
        if (visited[root.val]) {
            return;
        }
        visited[root.val] = true;
        map.put(root.val, new Node(root.val));
        for (Node tmp : root.neighbors) {
            traverse(tmp);
        }
    }
}
// @lc code=end

