/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        int i = 1;
        while (i < len && arr[i - 1] < arr[i]) {
            i++;
        }
        if (i == 1 || i == len) {
            return false;
        }
        while (i < len && arr[i - 1] > arr[i]) {
            i++;
        }
        if (i == len) {
            return true;
        }
        return false;
    }
}
// @lc code=end

