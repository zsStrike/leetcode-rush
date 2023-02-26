/*
 * @lc app=leetcode.cn id=779 lang=java
 *
 * [779] 第K个语法符号
 */

// @lc code=start
class Solution {
    // 0
    // 01
    // 0110
    // 01101001
    // 0110100110010110
    // 01101001100101101001011001101001

    // n 行 2^(n-1) 
    // n 是奇数，回文
    // n 是偶数，中心对称

    public int kthGrammar(int n, int k) {
        // System.out.println(n + " " + k);
        if (n == 1) {
            return 0;
        }
        int len = (int)Math.pow(2, n - 1);
        int mid = len / 2;
        if (n % 2 == 0) {
            if (k > mid) {
                return kthGrammar(n, mid - (k - mid - 1)) == 0 ? 1 : 0;
            }
            return kthGrammar(n - 1, k);
        } else {
            if (k > mid) {
                return kthGrammar(n, mid - (k - mid - 1));
            }
            return kthGrammar(n - 1, k);
        }
    }
}
// @lc code=end

