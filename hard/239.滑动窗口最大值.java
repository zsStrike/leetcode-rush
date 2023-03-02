import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    // 3 -1
    // 3 -1 -3 
    // 5
    // 5 3
    // 6
    // 7
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 递减序列
        if (k == 1) return nums;
        Deque<Integer> deque = new ArrayDeque<>();
        // for (int i = 0; i < k - 1; i++) {
        //     while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        //         deque.pollLast();
        //     }
        //     deque.offerLast(i);
        // }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);  
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[deque.peekFirst()];          
            }
        }
        return ans;
    }
}
// @lc code=end

