import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    // 0, 0 1, 1
    // n = 1
    // 0, 0  0, 0
    // 0, 1  0, 
    public Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, 0, 0, n - 1, n - 1);
    }
    private Node construct(int[][] grid, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return new Node(grid[x1][y1] == 0 ? false : true, true, null, null, null, null);
        }
        int n = x2 - x1;
        Node topLeft = construct(grid, x1, y1, x1 + n / 2, y1 + n / 2);
        Node topRight = construct(grid, x1, y1 + n / 2 + 1, x1 + n / 2, y2);
        Node bottomLeft = construct(grid, x1 + n / 2 + 1, y1, x2, y1 + n / 2);
        Node bottomRight = construct(grid, x1 + n / 2 + 1, y1 + n / 2 + 1, x2, y2);
        Node root;
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.val == topRight.val && bottomLeft.val == bottomRight.val
            && topLeft.val == bottomLeft.val) {
                root = new Node(topLeft.val, true, null, null, null, null);
            } else {
                root = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        return root;
    }
}
// @lc code=end

