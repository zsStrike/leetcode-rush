import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
    public int countPrimeSetBits(int left, int right) {
        Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 27, 29};
        HashSet<Integer> set = new HashSet<>(Arrays.asList(primes));
        int sum = 0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                count++;
                tmp &= tmp - 1;
            }
            if (set.contains(count)) {
                sum++;
            }
        }
        return sum;
    }
}
// @lc code=end

