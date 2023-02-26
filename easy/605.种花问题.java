/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int max = 0;
        int start = 0;
        while (start < len && flowerbed[start] == 0) {
            start++;
        }
        if (start == len) {
            return (len + 1) / 2 >= n;
        }
        max += start / 2;
        int end = len - 1;
        while (end > start && flowerbed[end] == 0) {
            end--;
        }
        max += (len - end - 1) / 2;
        int left = start + 1;
        while (left < end) {
            while (left < end && flowerbed[left] == 0) {
                left++;
            }
            max += (left - start - 1 - 1) / 2;
            // System.out.println(start + " " + left + " " + max);
            start = left;
            left = left + 1; 
        }
        return max >= n;
    }
}
// @lc code=end

