/*
 * @lc app=leetcode.cn id=1574 lang=java
 *
 * [1574] 删除最短的子数组使剩余数组有序
 */

// @lc code=start
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int[] narr = new int[n + 2];
        narr[0] = Integer.MIN_VALUE;
        narr[n + 1] = Integer.MAX_VALUE;
        System.arraycopy(arr, 0, narr, 1, n);
        int left = 0, right = n + 1;
        int min = n - 1;
        while (right > 0 && narr[right] >= narr[right - 1]) {
            right--;
        }
        if (right == 0) return 0;
        while (left < n + 2) {
            min = Math.min(right - left - 1, min);
            if (narr[left + 1] < narr[left]) {
                break;
            }
            left++;
            while (right < n + 2 && narr[right] < narr[left]) {
                right++;
            }
        }
        min = Math.min(right - left - 1, min);
        return min;
    }
}
// @lc code=end

