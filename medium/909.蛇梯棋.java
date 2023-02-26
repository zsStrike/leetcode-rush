import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.QueryEval;

/*
 * @lc app=leetcode.cn id=909 lang=java
 *
 * [909] 蛇梯棋
 */

// @lc code=start
class Solution {
    static int[][] dirs = {
        {0, 1}, {-1, 0}, {0, -1}, {-1, 0}
    };
    public int snakesAndLadders(int[][] board) {
        // 坐标 (i, j) + 编号 = 36
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = board.length;
        int key = 1;
        for (int i = n - 1; i >= 0; i -= 2) {
            for (int j = 0; j < n; j++) {
                map.put(key + j, new int[] {i, j, key + j});
            }
            key += 2 * n;
        }
        key = 1 + n;
        for (int i = n - 2; i >= 0; i -= 2) {
            for (int j = n - 1; j >= 0; j--) {
                map.put(key + n - 1 - j, new int[] {i, j, key + n - 1 - j});
            }
            key += 2 * n;
        }
        // System.out.println(map);
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(new int[] {n - 1, 0, 1});
        visited.add(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] data = queue.poll();
                if (data[2] == n * n) {
                    return count;
                }
                for (int j = 1; j <= 6; j++) {
                    int pos = Math.min(data[2] + j, n * n);
                    int[] tmp = map.get(pos);
                    if (board[tmp[0]][tmp[1]] != -1) {
                        pos = board[tmp[0]][tmp[1]];
                    }
                    if (!visited.contains(pos)) {
                        visited.add(pos);
                        queue.offer(map.get(pos));
                    }
                }
            }
            count++;
        }
        return -1;
    }
    // void bfs(int[][] board, int x, int y, )
}
// @lc code=end

