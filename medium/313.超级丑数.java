import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.scene.layout.Priority;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    // a b c d e f
    // 2a 2b 2c 2d 2e 2f
    // 3a 3b 3c 3d 3e 3f
    // 12 [2,7,13,19]
    // 1
    // 2
    // 4
    // 7
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        nums[0] = 1;

        int len = primes.length;
        int[] ptr = new int[len];

        // int num = 0;
        for (int i = 1; i < n; i++) {
            // System.out.println(Arrays.toString(ptr));
            // System.out.println(Arrays.toString(nums));
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < len; j++) {
                while (ptr[j] < n && primes[j] * nums[ptr[j]] <= nums[i - 1]) {
                    ptr[j]++;
                }
                if (ptr[j] == n) {
                    continue;
                }
                if (min > primes[j] * nums[ptr[j]]) {
                    min = primes[j] * nums[ptr[j]];
                    idx = j;
                }
            }
            ptr[idx]++;
            // num = min;
            nums[i] = min;
            // System.out.println(Arrays.toString(nums));
        }
        return nums[n - 1];
    }
}
// @lc code=end

