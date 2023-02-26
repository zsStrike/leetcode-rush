import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=611 lang=java
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int k = j + 1;
                while (k < len && nums[k] < nums[i] + nums[j]) {
                    k++;
                }
                ans += (k - j - 1);
            }
        }
        return ans;
    }
}
// @lc code=end

