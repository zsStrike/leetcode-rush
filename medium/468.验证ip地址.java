import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            if (validateIPv4(queryIP)) {
                return "IPv4";
            }
        } else {
            if (validateIPv6(queryIP)) {
                return "IPv6";
            }
        }
        return "Neither";
    }
    boolean validateIPv6(String ip) {
        if (ip.lastIndexOf(":") == ip.length() - 1) {
            return false;
        }
        String[] strs = ip.split(":");
        // System.out.println(Arrays.toString(strs));
        if (strs.length != 8) {
            return false;
        }
        for (String str : strs) {
            if (str.length() == 0 || str.length() > 4) {
                return false;
            }
            for (char c : str.toCharArray()) {
                if (Character.isDigit(c) || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    boolean validateIPv4(String ip) {
        if (ip.lastIndexOf(".") == ip.length() - 1) {
            return false;
        }
        String[] strs = ip.split("\\.");
        if (strs.length != 4) {
            return false;
        }
        for (String str : strs) {
            if (str.length() == 0 || str.length() > 3) {
                return false;
            }
            if (str.length() != 1 && str.charAt(0) == '0') {
                return false;
            }
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            int num = Integer.parseInt(str);
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

