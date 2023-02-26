/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = s.length();
        while (i < len) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int k = j;
                int count = 0;
                do {
                    if (s.charAt(k) == '[') {
                        count++;
                    } 
                    if (s.charAt(k) == ']') {
                        count--;
                    }
                    k++;
                } while (count != 0);
                int times = Integer.parseInt(s.substring(i, j));
                String str = decodeString(s.substring(j + 1, k - 1));
                while (times > 0) {
                    sb.append(str);
                    times--;
                }
                i = k;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

