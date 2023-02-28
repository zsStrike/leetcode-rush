import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=2363 lang=java
 *
 * [2363] 合并相似的物品
 */

// @lc code=start
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> maps = new TreeMap<>();
        for (int[] item : items1) {
            maps.put(item[0], maps.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            maps.put(item[0], maps.getOrDefault(item[0], 0) + item[1]);
        }
        List<List<Integer>> ans = new LinkedList<>();
        for (int key : maps.keySet()) {
            ans.add(Arrays.asList(key, maps.get(key)));
        }
        return ans;
    }
}
// @lc code=end

