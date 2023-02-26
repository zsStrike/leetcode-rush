/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
class Solution {
    // [1] [1]
    // [1 2] [2]
    // [1 2 3] [2]
    // [1 2 3 4] [2]
    // [1 2 3  4 5] [2]
    // [1 2 3 4 5 6] [4]
    // [1 2  3 4 5 6 7 8] [6]
    // 
    // [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16]
    // [2 4 6 8 10 12 14 16]
    // [2 6 10 14]
    // [6 14]
    // 6

    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        return (n / 2 + 1 - lastRemaining(n / 2)) * 2;
    }
}
// @lc code=end

