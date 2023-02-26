/*
 * @lc app=leetcode.cn id=558 lang=java
 *
 * [558] 四叉树交集
 */

// @lc code=start

// Definition for a QuadTree node.
// class Node {
//     public boolean val;
//     public boolean isLeaf;
//     public Node topLeft;
//     public Node topRight;
//     public Node bottomLeft;
//     public Node bottomRight;

//     public Node() {}

//     public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
//         val = _val;
//         isLeaf = _isLeaf;
//         topLeft = _topLeft;
//         topRight = _topRight;
//         bottomLeft = _bottomLeft;
//         bottomRight = _bottomRight;
//     }
// };


class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null && quadTree2 == null) {
            return null;
        }
        Node res = null;
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            quadTree1.val = quadTree1.val || quadTree2.val;
            res = quadTree1;
        } else if (quadTree1.isLeaf || quadTree2.isLeaf) {
            Node leafNode = quadTree1.isLeaf ? quadTree1 : quadTree2;
            Node nonLeafNode = quadTree1.isLeaf ? quadTree2 : quadTree1;
            if (leafNode.val) {
                res = leafNode;
            } else {
                res = nonLeafNode;
            }
        } else {
            res = new Node();
            res.isLeaf = false;
            res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            res.bottomLeft =  intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf) {
                if (res.topLeft.val == res.topRight.val && res.bottomLeft.val == res.bottomRight.val && res.topLeft.val == res.bottomLeft.val) {
                    res.isLeaf = true;
                    res.val = res.topLeft.val;
                    res.topLeft = res.topRight = res.bottomLeft = res.bottomRight = null;
                }
            }
        }
        return res;
    }
}
// @lc code=end

