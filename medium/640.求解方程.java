/*
 * @lc app=leetcode.cn id=640 lang=java
 *
 * [640] 求解方程
 */

// @lc code=start
class Solution {
    public String solveEquation(String equation) {
        // ax = b  x = b / a
        int a = 0, b = 0;
        String[] equs = equation.split("=");
        for (int i = 0; i < 2; i++) {
            String equ = equs[i];
            int start = 0, len = equ.length();
            while (start < len) {
                int end = start + 1;
                while (end < len && equ.charAt(end) != '+' && equ.charAt(end) != '-') {
                    end++;
                }
                if (equ.charAt(end - 1) == 'x') {
                    if (start == end - 1) {
                        a += 1;
                    } else {
                        if (equ.substring(start, end - 1).equals("+")) {
                            a += 1;
                        } else if (equ.substring(start, end - 1).equals("-")) {
                            a -= 1;
                        } else {
                            a += Integer.parseInt(equ.substring(start, end - 1));
                        }
                    }
                } else {
                    b += Integer.parseInt(equ.substring(start, end));
                }
                start = end;
            }
            System.out.println(a + " " + b);
            a = -a;
            b = -b;
        }
        if (a == 0 && b == 0) {
            return "Infinite solutions";
        } else if (a == 0) {
            return "No solution";
        } else if (b % a == 0) {
            return "x=" + (-b / a);
        } else {
            return "No solution";
        }
    }
}
// @lc code=end

