import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2071 lang=java
 *
 * [2071] 你可以安排的最多任务数目
 */

// @lc code=start
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(workers);
        Arrays.sort(tasks);
        int n = tasks.length, m = workers.length;
        int i = n - 1, j = m - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            if (workers[j] == -1) {
                j--;
            } else if (workers[j] >= tasks[i]) {
                j--;
                i--;
                count++;
            } else if (pills > 0 && workers[j] + strength >= tasks[i]) {
                int k = j;
                while (k >= 0 && workers[k] + strength >= tasks[i]) {
                    k--;
                }
                i--;
                k++;
                while (workers[k] == -1) {
                    k++;
                }
                workers[k] = -1;
                pills--;
                count++;
            } else {
                i--;
            }
        }
        return count;
    }
}
// @lc code=end

