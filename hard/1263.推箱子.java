/*
 * @lc app=leetcode.cn id=1263 lang=java
 *
 * [1263] 推箱子
 */

// @lc code=start
// [["#","#","#","#","#","#"],
//  ["#","T",".",".","#","#"],
//  ["#",".","#","B",".","#"],
//  ["#",".",".",".",".","#"],
//  ["#",".",".",".","S","#"],
//  ["#","#","#","#","#","#"]]

/**
 *[["#",".",".","#","T","#","#","#","#"],
 * ["#",".",".","#",".","#",".",".","#"],
 * ["#",".",".","#",".","#","B",".","#"],
 * ["#",".",".",".",".",".",".",".","#"],
 * ["#",".",".",".",".","#",".","S","#"],
 * ["#",".",".","#",".","#","#","#","#"]]
 * 
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class State {
        int si, sj;
        int bi, bj;
        char[][] grid;
        State(char[][] grid) {
            this.grid = new char[grid.length][];
            for (int i = 0; i < grid.length; i++) {
                this.grid[i] = Arrays.copyOf(grid[i], grid[i].length);
            }   
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 'S') {
                        si = i;
                        sj = j;
                    }
                    if (grid[i][j] == 'B') {
                        bi = i;
                        bj = j;
                    }
                }
            }         
        }
        @Override
        public boolean equals(Object obj) {
            State that = (State)obj;
            return this.si == that.si && this.sj == that.sj && this.bi == that.bi && this.bj == that.bj;
        }
        @Override
        public int hashCode() {
            return si << 24 + sj << 16 + bi << 8 + bj;
        }
        @Override
        public String toString() {
            return String.format("si=%d sj=%d bi=%d bj=%d", si, sj, bi, bj);
        }
    }
    /*
     * 箱子能左移动：箱子右边必须为空，且人物能够移动到箱子右边
     * 记录状态：箱子位置，箱子上次移动状态
     */
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minPushBox(char[][] grid) {
        int ti = 0, tj = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'T') {
                    ti = i; 
                    tj = j;
                    grid[i][j] = '.';
                }
            }
        }
        State st = new State(grid);
        Queue<State> queue = new LinkedList<>();
        queue.offer(st);
        HashSet<State> set = new HashSet<>();
        set.add(st);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State state = queue.poll();
                // System.out.println(state);
                if (state.bi == ti && state.bj == tj) return count;
                for (int[] d : dirs) {
                    int npi = state.bi + d[0];
                    int npj = state.bj + d[1];
                    if (!canMoveTo(state.grid, state.si, state.sj, npi, npj)) {
                        continue;
                    }
                    int nbi = state.bi - d[0];
                    int nbj = state.bj - d[1];
                    if (nbi < 0 || nbj < 0 || nbi >= m || nbj >= n) {
                        continue;
                    }
                    if (state.grid[nbi][nbj] == '#') {
                        continue;
                    }
                    // System.out.println(Arrays.deepToString(state.grid));
                    state.grid[state.si][state.sj] = '.';
                    state.grid[state.bi][state.bj] = 'S';
                    state.grid[nbi][nbj] = 'B';
                    State next = new State(state.grid);
                    if (!set.contains(next)) {
                        // System.out.println(Arrays.deepToString(state.grid));
                        queue.offer(next);
                        set.add(next);
                    }
                    state.grid[nbi][nbj] = '.';
                    state.grid[state.bi][state.bj] = 'B';
                    state.grid[state.si][state.sj] = 'S';                    
                }
            }
            count++;
            // System.out.println("-----------------");
        }
        return -1;
    }

    boolean canMoveTo(char[][] grid, int pi, int pj, int ti, int tj) {
        int m = grid.length, n = grid[0].length;
        if (ti < 0 || tj < 0 || ti >= m || tj >= n) {
            return false;
        }
        if (pi == ti && pj == tj) return true;
        if (grid[ti][tj] == '#') return false;
        char[][] visited = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        return dfs(grid, pi, pj, ti, tj, visited);
    }
    boolean dfs(char[][] grid, int pi, int pj, int ti, int tj, char[][] visited) {
        if (pi == ti && pj == tj) {
            return true;
        }
        visited[pi][pj] = '#';
        int m = grid.length, n = grid[0].length;
        for (int[] d : dirs) {
            int npi = pi + d[0];
            int npj = pj + d[1];
            if (npi < 0 || npj < 0 || npi >= m || npj >= n) {
                continue;
            }
            if (visited[npi][npj] == '#' || visited[npi][npj] == 'B') continue;
            if (dfs(grid, npi, npj, ti, tj, visited)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

