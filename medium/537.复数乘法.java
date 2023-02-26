/*
 * @lc app=leetcode.cn id=537 lang=java
 *
 * [537] 复数乘法
 */

// @lc code=start
class Solution {
    // a + bi    c + di
    // ac - bd   ad + dc
    public String complexNumberMultiply(String num1, String num2) {
        int[] n1 = decode(num1);
        int[] n2 = decode(num2);
        int a = n1[0] * n2[0] - n1[1] * n2[1];
        int b = n1[1] * n2[0] + n1[0] * n2[1];
        return a + "+" + b + "i";
    }
    int[] decode(String num) {
        String[] ss = num.split("\\+");
        int[] ans = new int[2];
        ans[0] = Integer.parseInt(ss[0]);
        ans[1] = Integer.parseInt(ss[1].split("i")[0]);
        return ans;
    }
}
// @lc code=end

