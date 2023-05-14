/*
 * @lc app=leetcode.cn id=1053 lang=java
 *
 * [1053] 交换一次的先前排列
 */

// @lc code=start
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int first = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                first = i;
                break;
            }
        }
        if (first == -1) return arr;
        int second = first + 1;
        while (second < n && arr[second] < arr[first]) {
            second++;
        }
        second--;
        while (second > 0 && arr[second] == arr[second - 1]) {
            second--;
        }
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
        return arr;
    }
}
// @lc code=end

