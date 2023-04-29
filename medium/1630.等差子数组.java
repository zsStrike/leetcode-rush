import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1630 lang=java
 *
 * [1630] 等差子数组
 */

// @lc code=start
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int size = l.length;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int[] copy = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(copy);
            // System.out.println(Arrays.toString(copy));
            list.add(check(copy));
        }
        return list;
    }
    private boolean check(int[] nums) {
        int left = 0, right = nums.length - 1;
        int delta = nums[left + 1] - nums[left];
        // System.out.println(delta);
        for (int i = left + 1; i <= right; i++) {
            if (delta != nums[i] - nums[i - 1]) {
                // System.out.println(delta + " " + (nums[i] - nums[i - 1]));
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

