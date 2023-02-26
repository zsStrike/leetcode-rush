import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, (String a, String b) -> {
            String ab = a + b;
            String ba = b + a;
            return ab.compareTo(ba);
        });
        if (strs[n - 1].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

