import java.util.Arrays;

import javafx.scene.layout.Priority;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], -1);
        }
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            int tmp = people[i][1];
            int count = 0;
            int j = 0;
            for (; j < n; j++) {
                if (ans[j][0] != -1) {
                    continue;
                }
                if (count == tmp) {
                    break;
                }                
                count++;
            }
            ans[j] = people[i];
        }
        return ans;
    }
}
// @lc code=end

