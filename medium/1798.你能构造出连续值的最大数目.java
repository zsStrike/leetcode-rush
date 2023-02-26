import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1798 lang=java
 *
 * [1798] 你能构造出连续值的最大数目
 */

// @lc code=start
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int last = 0;
        for (int coin : coins) {
            if (coin > last + 1) {
                break;
            }
            last = last + coin;
        }
        return last + 1;
    }
}
// @lc code=end

