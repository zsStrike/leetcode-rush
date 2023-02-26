/*
 * @lc app=leetcode.cn id=822 lang=java
 *
 * [822] 翻转卡片游戏
 */

// @lc code=start
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int min = Integer.MAX_VALUE;
        int n = fronts.length;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                continue;
            }
            int num = fronts[i];
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (fronts[j] == num && backs[j] == num) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                min = Math.min(num, min);
            }
            num = backs[i];
            flag = true;
            for (int j = 0; j < n; j++) {
                if (fronts[j] == num && backs[j] == num) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                min = Math.min(num, min);
            }            
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// @lc code=end

