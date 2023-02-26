/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int len = cs.length;
        char[] leftMax = new char[len];
        char[] rightMax = new char[len];
        rightMax[len - 1] = cs[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = (char)Math.max(cs[i], rightMax[i+1]);
        }
        for (int i = 0; i < len - 1; i++) {
            if (cs[i] < rightMax[i + 1]) {
                int j = len - 1;
                while (cs[j] != rightMax[i + 1]) {
                    j--;
                }
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                return Integer.parseInt(String.valueOf(cs));
            }
        }
        return Integer.parseInt(String.valueOf(cs)); 
    }
}
// @lc code=end

