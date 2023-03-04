/*
 * @lc app=leetcode.cn id=982 lang=java
 *
 * [982] 按位与为零的三元组
 */

// @lc code=start
class Solution {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = nums[i] & nums[j];
                for (int k = j; k < n; k++) {
                    if ((tmp & nums[k]) != 0) {
                        continue;
                    }
                    if (i == j && j == k) {
                        ans++;
                    } else if (i == j || j == k) {
                        ans += 3;
                    } else {
                        ans += 6;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

