import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        String sum = "0";
        for (int i = len2 - 1; i >= 0; i--) {
            String tmp = multiply(num1, num2.charAt(i));
            int j = len2 - i - 1;
            while (j-- >0 && !tmp.equals("0")) {
                tmp += "0";
            }
            sum = add(sum, tmp);
        }
        return sum;
    }
    String multiply(String num1, char num2) {
        String sum = "0";
        for (int i = '0'; i < num2; i++) {
            sum = add(sum, num1);
        }
        return sum;
    }
    String add(String num1, String num2) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            list.addFirst(sum % 10);
            i--;
            j--;
        }      
        if (carry > 0) {
            list.addFirst(carry);
        } 
        // System.out.println(list);
        return list.stream().map(a -> a.toString()).reduce("", (a, b) -> a + b);
    }
}
// @lc code=end

