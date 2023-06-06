import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            int pa = uf.getParent(edge[0]);
            int pb = uf.getParent(edge[1]);
            if (pa == pb) {
                return edge;
            }
            uf.union(pa, pb);
        }
        return null;
    }
}

class UnionFind {
    int[] parents;
    UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    int getParent(int i) {
        int cur = i;
        int par = parents[i];
        while (cur != par) {
            cur = par;
            par = parents[par];
        } 
        parents[i] = par;
        return par;
    }
    void union(int i, int j) {
        int pi = getParent(i);
        int pj = getParent(j);
        parents[pi] = pj;
    }
}
// @lc code=end

