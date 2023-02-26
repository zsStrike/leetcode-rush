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
        int[] parent = new int[n]; // bigger -> small
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int cur = j;
                    int par = parent[j];
                    while (cur != par) {
                        cur = par;
                        par = parent[par];
                    }
                    // parent[cur] = i;
                    int a = i;
                    int p = parent[a];
                    while (a != p) {
                        a = p;
                        p = parent[p];
                    }
                    if (par < p) {
                        parent[p] = par;
                    } else {
                        parent[par] = p;
                    }
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int cur = i;
            int par = parent[i];
            while (par != cur) {
                cur = par;
                par = parent[par];
            }
            set.add(par);
        }
        return set.size();
    }
}
// @lc code=end

