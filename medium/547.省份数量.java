import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    // 1 0 0 1 1 和 4  4 -> 1
    // 0 1 1 0 2 和 3  3 -> 2
    // 0 1 1 1 3 和 4  4 -> 3
    // 1 0 1 1
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(uf.getParent(i));
        }
        return set.size();
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

