import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果交换
 */

// @lc code=start
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = Arrays.stream(aliceSizes).sum();
        int sum2 = Arrays.stream(bobSizes).sum();
        int delta = (sum1 - sum2) / 2;
        for (int a : aliceSizes) {
            for (int b : bobSizes) {
                if (a - b == delta) {
                    return new int[] {a, b};
                }
            }
        }
        return new int[2];
    }
}
// @lc code=end

