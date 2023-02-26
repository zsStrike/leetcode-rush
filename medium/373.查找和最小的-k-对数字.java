import java.util.*;

/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的 K 对数字
 */

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ptr = new int[n1];
        // [0] num1 位置 [1] num2 位置, [2] 元素和
        List<List<Integer>> ans = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n1; i++) {
            queue.offer(new int[] {i, 0, nums1[i] + nums2[0]});
        }
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                break;
            }
            int[] tmp = queue.poll();
            ans.add(Arrays.asList(nums1[tmp[0]], nums2[tmp[1]]));
            tmp[1]++;
            if (tmp[1] != n2) {
                tmp[2] = nums1[tmp[0]] + nums2[tmp[1]];
                queue.offer(tmp);
            }
        }
        return ans;
    }
}
// @lc code=end

