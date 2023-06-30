/*
 * @lc app=leetcode.cn id=1483 lang=java
 *
 * [1483] 树节点的第 K 个祖先
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class TreeAncestor {
    SkipList list;
    public TreeAncestor(int n, int[] parent) {
        list = new SkipList(n, parent);
    }
    
    public int getKthAncestor(int node, int k) {
        int p = node;
        for (int i = 19; i >= 0; i--) {
            while (k >= (1 << i) && p != -1) {
                p = list.nodes[p].p[i];
                k -= (1 << i);
            }
        }
        return p;
    }
}

class SkipList {
    class SkipListNode {
        int node;
        int[] p;
        boolean init;
        SkipListNode(int node, int parent) {
            this.node = node;
            this.init = false;
            p = new int[20];
            Arrays.fill(p, -1);
            p[0] = parent;
        }
    }
    SkipListNode[] nodes;
    SkipList(int n, int[] parent) {
        nodes = new SkipListNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new SkipListNode(n, parent[i]);
        }
        nodes[0].init = true;
        for (int i = 1; i < n; i++) {
            initNode(i);
        }
    }

    void initNode(int i) {
        SkipListNode node = nodes[i];
        if (node.init) return;
        for (int j = 1; j < 20; j++) {
            int pi = node.p[j - 1];
            if (pi == -1) {
                break;
            }
            initNode(pi);
            pi = nodes[pi].p[j - 1];
            node.p[j] = pi;
        }
        node.init = true;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
// @lc code=end

