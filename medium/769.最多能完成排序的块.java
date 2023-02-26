import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=769 lang=java
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, left = 0;
        int count = 0;
        while (left < n) {
            int right = left;
            while (right < n && !check(arr, left, right)) {
                right++;
            }
            count++;
            left = right + 1;
        }
        return count;
    }
    boolean check(int[] arr, int left, int right) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = left; i <= right; i++) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) != 2) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

