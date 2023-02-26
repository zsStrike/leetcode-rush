/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n1 < n2) {
            return gcdOfStrings(str2, str1);
        }
        int max = 0;
        while (max < n2 && str1.charAt(max) == str2.charAt(max)) {
            max++;
        }
        if (max == 0) {
            return "";
        }
        for (int i = max; i > 0; i--) {
            if (max % i != 0 || n1 % i != 0 || n2 % i != 0) {
                continue;
            }
            String pat = str2.substring(0, i);
            int c1 = n1 / i, c2 = n2 / i;
            StringBuilder sb = new StringBuilder();
            while (c1 > 0) {
                sb.append(pat);
                c1--;
            }
            if (!sb.toString().equals(str1)) {
                continue;
            }
            sb = new StringBuilder();
            while (c2 > 0) {
                sb.append(pat);
                c2--;
            }
            if (sb.toString().equals(str2)) {
                return pat;
            }
        }
        return "";
    }
}
// @lc code=end

