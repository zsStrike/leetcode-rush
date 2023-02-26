import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] zeros = new int[n];
        int[] ones = new int[n];
        if (nums[0] == 0) {
            zeros[0] = 1;
        } else {
            ones[0] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros[i] = 1 + zeros[i - 1];
                ones[i] = ones[i - 1];
            } else {
                zeros[i] = zeros[i - 1];
                ones[i] = 1 + ones[i - 1];                
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int key = ones[i] - zeros[i];
            if (key == 0) {
                max = Math.max(max, i + 1);
            } else if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);                
            }
        }
        return max;
    }
}
// @lc code=end

