import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int res = num1.charAt(i) + num2.charAt(j) - 2 * '0' + carry;
            sb.append(res % 10);
            carry = res / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int res = num1.charAt(i) + carry - '0';
            sb.append(res % 10);
            carry = res / 10;
            i--;
        }
        while (j >= 0) {
            int res = num2.charAt(j) + carry - '0';
            sb.append(res % 10);
            carry = res / 10; 
            j--;           
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

