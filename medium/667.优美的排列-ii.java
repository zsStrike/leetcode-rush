import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=667 lang=java
 *
 * [667] 优美的排列 II
 */

// @lc code=start
class Solution {
    
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int lo = 1, hi = n;
        int i;
        for (i = 0; i < k; i++) {
            ans[i] = i % 2 == 0 ? lo++ : hi--;
        }
        if (i % 2 == 0) {
            while (i < n) {
                ans[i] = hi--;
                i++;
            }
        } else {
            while (i < n) {
                ans[i] = lo++;
                i++;
            }
        }
        return ans;
    }
    
}
// @lc code=end

