/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int left = 0;
        while (left < n && seats[left] == 0) {
            left++;
        }
        int right = n - 1;
        while (right >= 0 && seats[right] == 0) {
            right--;
        }
        int max = Math.max(left, n - right - 1);
        int cur = left + 1;
        while (cur < right) {
            while (cur < right && seats[cur] == 0) {
                cur++;
            }
            max = Math.max(max, (cur - left) / 2);
            left = cur;
            cur = cur + 1;
        }
        return max;
    }
    
}
// @lc code=end

