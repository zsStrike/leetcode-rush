import java.util.LinkedList;


/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int left = 0, right = 1;
        int len = nums.length;
        List<String> ans = new LinkedList<>();
        while(left < len) {
            while (right < len && nums[right - 1] == nums[right] - 1) {
                right++;
            }
            if (right > left + 1) {
                ans.add(nums[left] + "->" + nums[right - 1]);
            } else {
                ans.add(nums[left] + "");
            }
            left = right;
            right = right + 1;
        }
        return ans;
    }
}
// @lc code=end

