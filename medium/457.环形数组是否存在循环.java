/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组是否存在循环
 */

// @lc code=start
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int slow = i;
            int fast = i;
            do {
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, fast);
                if (fast != -1) {
                    fast = getNextIndex(nums, fast);
                }
                if (fast == -1 || nums[slow] == 0 || nums[fast] == 0) {
                    break;
                }
            } while (slow != fast);
            if (slow != -1 && slow == fast) {
                return true;
            }
            nums[i] = 0;
        }
        return false;
    }
    private int getNextIndex(int[] nums, int cur) {
        int next = ((cur + nums[cur]) % nums.length + nums.length) % nums.length;
        // System.out.println(cur + " " + next);
        if (nums[next] == 0 || next == cur || nums[next] * nums[cur] < 0) {
            return -1;
        }
        return next;
    }
}
// @lc code=end

