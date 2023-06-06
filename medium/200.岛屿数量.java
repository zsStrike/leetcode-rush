/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int m = grid.length, n = grid[0].length;
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == '0') {
                continue;
            }
            dfs(grid, nx, ny);
        }
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

