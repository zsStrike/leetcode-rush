/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */

// @lc code=start
class Solution {
    // 2n <= 100
    // 定义 dp[2*i] 表示 2i 结尾的调度，
    // 最后两个人各自前往
    public int twoCitySchedCost(int[][] costs) {
        // 偶数前往a ，奇数前往b
        int n = costs.length;
        boolean isOptimal = false;
        while (!isOptimal) {
            isOptimal = true;
            for (int i = 0; i < n; i += 2) {
                for (int j = 1; j < n; j += 2) {
                    if (costs[i][0] + costs[j][1] > costs[i][1] + costs[j][0]) {
                        int[] tmp = costs[i];
                        costs[i] = costs[j];
                        costs[j] = tmp;
                        isOptimal = true;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i % 2 == 0 ? costs[i][0] : costs[i][1];
        }
        return sum;
    }
}
// @lc code=end

