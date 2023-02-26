/*
 * @lc app=leetcode.cn id=592 lang=java
 *
 * [592] 分数加减运算
 */

// @lc code=start
class Solution {
    public String fractionAddition(String expression) {
        int preu = 0, preb = 1;
        int left = 0;
        int right = 1;
        int n = expression.length();
        while (left < n) {
            right = left + 1;
            while (right < n && expression.charAt(right) != '+' && expression.charAt(right) != '-') {
                right++;
            }
            String[] ss = expression.substring(left, right).split("/");
            int curu = Integer.parseInt(ss[0]);
            int curb = Integer.parseInt(ss[1]);
            // System.out.println(preu + " " + preb);
            // System.out.println(curu + " " + curb);

            preu = preu * curb + curu * preb;
            preb = preb * curb;
            if (preu == 0) {
                preb = 1;
            } else {
                int max = gcd(Math.abs(preu), Math.abs(preb));
                preb /= max;
                preu /= max;
            }
            left = right;
        }
        return preu + "/" + preb;
    }
    int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
// @lc code=end

