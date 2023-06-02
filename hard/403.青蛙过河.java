import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
    HashMap<String, Boolean> memo;
    public boolean canCross(int[] stones) {
        memo = new HashMap<>();
        return canCross(stones, 0, 0);
    }
    boolean canCross(int[] stones, int idx, int prek) {
        String key = idx + " " + prek;
        if (memo.containsKey(key)) return memo.get(key);
        int n = stones.length;
        if (idx == n - 1) return true;
        boolean ans = false;
        label:
        for (int i = -1; i <= 1; i++) {
            if (prek + i <= 0) {
                continue;
            }
            for (int j = idx + 1; j < n; j++) {
                if (stones[idx] + prek + i == stones[j]) {
                    if (canCross(stones, j, prek + i)) {
                        ans = true;
                        break label;
                    }
                } else if (stones[idx] + prek + i < stones[j]) {
                    break;
                }
            }
        }
        memo.put(key, ans);
        return ans;
    }
}
// @lc code=end

