import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        // 正数表示正常，负数表示组成的环有几个
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int slow = i, fast = i;
            int count = 0;
            do {
                count++;
                slow = nums[slow];
                if (map.containsKey(slow)) {
                    count += map.get(slow);
                    break;
                }
                fast = nums[fast];
                fast = nums[fast];
            } while (slow != fast);
            max = Math.max(max, count);
            if (slow != fast) {
                fast = i;
                while (fast != slow) {
                    map.put(fast, count--);
                    fast = nums[fast];
                }
            } else {
                slow = i;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }            
                slow = i;
                while (slow != fast) {
                    map.put(slow, count--);
                    slow = nums[slow];
                }
                do {
                    map.put(slow, count);
                    slow = nums[slow];
                } while (slow != fast);
            }

        }
        return max;
    }
}
// @lc code=end

