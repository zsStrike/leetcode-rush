/*
 * @lc app=leetcode.cn id=866 lang=java
 *
 * [866] 回文素数
 */

// @lc code=start
class Solution {
    // 
    public int primePalindrome(int n) {
        while (true) {
            if (10_000_000 < n && n< 100_000_000)
                n = 100_000_000;
            if (isPrime(n) && isPalindrome(n)) {
                return n;
            }
            n++;
        }
    }
    boolean isPalindrome(int n) {
        String number = String.valueOf(n);
        int len = number.length();
        int left = 0, right = len - 1;
        while (left < right) {
            if (number.charAt(left) != number.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 11) {
            return true;
        }
        if (String.valueOf(n).length() % 2 == 0) {
            return false;
        }
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

