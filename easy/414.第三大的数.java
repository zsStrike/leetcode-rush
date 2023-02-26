import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        int firstMax, secondMax, thirMax;
        firstMax = secondMax = thirMax = Integer.MIN_VALUE;
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            if (nums[i] > firstMax) {
                thirMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax && nums[i] < firstMax) {
                thirMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirMax && nums[i] < secondMax) {
                thirMax = nums[i];
            }
        }
        return set.size() < 3 ? firstMax : thirMax;
    }
}
// @lc code=end

