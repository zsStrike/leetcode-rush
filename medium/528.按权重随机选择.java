import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 */

// @lc code=start
class Solution {

    TreeMap<Double, Integer> map;

    public Solution(int[] w) {
        int n = w.length;
        map = new TreeMap<>();
        int total = Arrays.stream(w).sum();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += w[i];
            map.put(sum / total, i);
        }
    }
    
    public int pickIndex() {
        Random random = new Random();
        double t = random.nextDouble();
        return map.get(map.ceilingKey(t));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

