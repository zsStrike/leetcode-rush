import java.util.Arrays;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] node = new int[n][2];
        for (int i = 0; i < n; i++) {
            node[i] = new int[] {difficulty[i], profit[i]};
        }
        // diff 升序  相同则按照profit降序
        Arrays.sort(node, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int pre = node[0][1];
        map.put(node[0][0], node[0][1]);
        for (int i = 1; i < n; i++) {
            if (node[i][0] == node[i - 1][0]) {
                continue;
            } else if (node[i][1] <= pre) {
                continue;
            } else {
                pre = node[i][1];
                map.put(node[i][0], node[i][1]);
            }
        }
        int m = worker.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            Integer key = map.floorKey(worker[i]);
            if (key != null) {
                sum += map.get(key);
            }
        }
        return sum;
    }
}
// @lc code=end

