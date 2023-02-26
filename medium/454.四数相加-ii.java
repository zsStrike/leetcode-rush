import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map1 = genMap(nums1, nums2);
        HashMap<Integer, Integer> map2 = genMap(nums3, nums4);
        int count = 0;
        for (int k1 : map1.keySet()) {
            if (map2.containsKey(-k1)) {
                count += map1.get(k1) * map2.get(-k1);
            }
        }
        return count;
    }
    HashMap<Integer, Integer> genMap(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        return map;
    }
}
// @lc code=end

