import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class Solution {
    // a / b / c / d
    // a / (b / c / d)
    // (a / b) / (c / d)
    public String optimalDivision(int[] nums) {
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        double res = maxinum(nums, 0, nums.length - 1, sb);
        System.out.println(res);
        return sb.toString();
    }
    private double minimal(int[] nums, int start, int end, StringBuilder sb) {
        if (start == end) {
            sb.append(nums[start]);
            return nums[start];
        }
        double min = 100000;
        for (int i = start + 1; i <= end; i++) {
            StringBuilder minsb = new StringBuilder();
            StringBuilder maxsb = new StringBuilder();
            double tmp = minimal(nums, start, i - 1, minsb) / maxinum(nums, i, end, maxsb);
            if (min > tmp) {
                sb.setLength(0);
                sb.append(minsb.toString() + "/" + maxsb.toString() + "");
                min = tmp;
            }
        }
        return min;
    }
    private double maxinum(int[] nums, int start, int end, StringBuilder sb) {
        if (start == end) {
            sb.append(nums[start]);
            return nums[start];
        }
        double max = 0;
        for (int i = start + 1; i <= end; i++) {
            StringBuilder minsb = new StringBuilder();
            StringBuilder maxsb = new StringBuilder();            
            double tmp = maxinum(nums, start, i - 1, maxsb) / minimal(nums, i, end, minsb);
            if (max < tmp) {
                sb.setLength(0);
                sb.append(maxsb.toString() + "/(" + minsb.toString() + ")");
                max = tmp;
            }
        }
        return max;
    }
}
// @lc code=end

