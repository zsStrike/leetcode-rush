/*
 * @lc app=leetcode.cn id=1653 lang=java
 *
 * [1653] 使字符串平衡的最少删除次数
 */

// @lc code=start
class Solution {
    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] leftA = new int[n], leftB = new int[n];
        int[] rightA = new int[n], rightB = new int[n];
        leftA[0] = cs[0] == 'a' ? 1 : 0;
        leftB[0] = cs[0] == 'b' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            leftA[i] = cs[i] == 'a' ? leftA[i - 1] + 1 : leftA[i - 1];
            leftB[i] = cs[i] == 'b' ? leftB[i - 1] + 1 : leftB[i - 1];
        }
        rightA[n - 1] = cs[n - 1] == 'a' ? 1 : 0;
        rightB[n - 1] = cs[n - 1] == 'b' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            rightA[i] = cs[i] == 'a' ? 1 + rightA[i + 1] : rightA[i + 1];
            rightB[i] = cs[i] == 'b' ? 1 + rightB[i + 1] : rightB[i + 1];
        }
        if (leftB[n - 1] == 0 || rightA[0] == 0) {
            return 0;
        }
        int min = n;
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'a') {
                min = Math.min(min, leftB[i] + rightA[i] - 1);
            } else {
                min = Math.min(min, rightA[i] + leftB[i] - 1);
            }
        }
        return min;
    }
}
// @lc code=end

